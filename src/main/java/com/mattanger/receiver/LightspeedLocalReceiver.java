package com.mattanger.receiver;

import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.util.Throwables;
import com.mattanger.model.KeyStoreConfiguration;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.net.Socket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A modified copy of the LocalServerReceiver in the Google OAuth client.
 * Specialized for Lightspeed use.
 */
public class LightspeedLocalReceiver implements VerificationCodeReceiver {

    private final Lock lock = new ReentrantLock();
    private String error;
    private String code;
    private final Condition gotAuthorizationResponse = lock.newCondition();
    private int port;
    private final String host;
    private final String protocol;
    private boolean useSSL;
    private KeyStoreConfiguration keyStoreConfiguration;
    private Server server;

    /**
     *
     * @param port
     * @param host
     * @param protocol
     */
    public LightspeedLocalReceiver(int port, String host, String protocol) {
        this.port = port;
        this.host = host;
        this.protocol = protocol;
    }

    /**
     *
     * @param keyStoreConfiguration
     */
    private void enableSSL(KeyStoreConfiguration keyStoreConfiguration) {
        this.useSSL = true;
        this.keyStoreConfiguration = keyStoreConfiguration;
    }

    @Override
    public String getRedirectUri() throws IOException {
        this.server = new Server();
        ServerConnector connector;
        if (this.useSSL) {
            connector = configureSSL(this.port);
        } else {
            connector = new ServerConnector(this.server);
            connector.setPort(this.port);
        }
        this.server.setConnectors(new Connector[] {connector});
        this.server.setHandler(new RedirectHandler());
        try {
            this.server.start();
        } catch (Exception e) {
            throw new IOException(e);
        }
        return this.protocol + "://" + this.host + ":" + this.port;
    }

    @Override
    public String waitForCode() throws IOException {
        lock.lock();
        try {
            while (code == null && error == null) {
                gotAuthorizationResponse.awaitUninterruptibly();
            }
            if (error != null) {
                throw new IOException("User authorization failed (" + error + ")");
            }
            return code;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void stop() throws IOException {
        if (server != null) {
            try {
                server.stop();
            } catch (Exception e) {
                Throwables.propagateIfPossible(e);
                throw new IOException(e);
            }
            server = null;
        }
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public String startFlow() throws IOException {
        return "";
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public String awaitCode() throws IOException {
        return "";
    }

    /**
     *
     * @param port
     * @return
     */
    public ServerConnector configureSSL(int port) {
        HttpConfiguration https = new HttpConfiguration();
        https.addCustomizer(new SecureRequestCustomizer());
        SslContextFactory sslContextFactory = new SslContextFactory();
        sslContextFactory.setKeyStorePath(this.keyStoreConfiguration.getKeyStorePath());
        sslContextFactory.setKeyStorePassword(this.keyStoreConfiguration.getKeyStorePassword());
        sslContextFactory.setKeyManagerPassword(this.keyStoreConfiguration.getKeyManagerPassword());
        ServerConnector sslConnector = new ServerConnector(server,
                new SslConnectionFactory(sslContextFactory, "http/1.1"),
                new HttpConnectionFactory(https));
        sslConnector.setPort(port);
        return sslConnector;
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public int getUnusedPort() throws IOException {
        Socket s = new Socket();
        s.bind(null);
        try {
            return s.getLocalPort();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }
        return -1;
    }

    /**
     *
     */
    public static final class Builder {
        private int port;
        private String host;
        private String protocol;
        private KeyStoreConfiguration keyStoreConfiguration;
        private boolean useSSL;

        /**
         *
         * @return
         */
        public LightspeedLocalReceiver build() {
            LightspeedLocalReceiver localReceiver =  new LightspeedLocalReceiver(this.port, this.host, this.protocol);
            if (useSSL)
                localReceiver.enableSSL(this.keyStoreConfiguration);
            return localReceiver;
        }

       /**
         *
         * @param port
         * @return
         */
        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        /**
         *
         * @param host
         * @return
         */
        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        /**
         *
         * @param method
         * @return
         * @throws ProtocolException
         */
        public Builder setProtocol(String method) throws ProtocolException {
            if (!method.toLowerCase().equals("http") && !method.toLowerCase().equals("https"))
                throw new ProtocolException("Protocol is not supported! Must be http or https.");
            if (method.toLowerCase().equals("https"))
                this.useSSL = true;
            this.protocol = method;
            return this;
        }

        /**
         *
         * @param keyStoreConfiguration
         * @return
         */
        public Builder setKeyStorePath(KeyStoreConfiguration keyStoreConfiguration) {
            this.keyStoreConfiguration = keyStoreConfiguration;
            return this;
        }
    }

    /**
     *
     */
    class RedirectHandler extends AbstractHandler {

        /**
         *
         * @param target
         * @param baseRequest
         * @param request
         * @param response
         * @throws IOException
         * @throws ServletException
         */
        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

            writeLandingHtml(response);
            response.flushBuffer();
            ((Request) request).setHandled(true);
            lock.lock();
            try {
                error = request.getParameter("error");
                code = request.getParameter("code");
                gotAuthorizationResponse.signal();
            } finally {
                lock.unlock();
            }
        }

        //todo personalize this
        private void writeLandingHtml(HttpServletResponse response) throws IOException {
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/html");
            PrintWriter doc = response.getWriter();
            doc.println("<html>");
            doc.println("<head><title>OAuth 2.0 Authentication Token Received</title></head>");
            doc.println("<body>");
            doc.println("Received verification code. You may now close this window...");
            doc.println("</body>");
            doc.println("</HTML>");
            doc.flush();
        }
    }
}

