package com.mattanger.old;
import com.mattanger.Constants;
import com.mattanger.old.OAuthHandler;
import com.sun.net.httpserver.*;
import javax.net.ssl.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.security.cert.Certificate;

/**
 *
 */
public class RedirectListener {

    private String _keyStore;
    private String _keyStorePassword;
    private HttpsServer _server;
    private HttpServer _httpServer;

    /**
     *
     * @param keyStore
     * @param keyStorePassword
     */
    public RedirectListener(String keyStore, String keyStorePassword) {
        _keyStore = keyStore;
        _keyStorePassword = keyStorePassword;
    }

    /**
     *
     * @param port
     */
    public void listen(int port) {
        if (_server == null) {
            _server = createSSLServer(port);
        }
        _server.start();
        System.out.println("Starting server on port: " + port);
    }

    /**
     *
     */
    public void stop() {
        if (_server != null)
            _server.stop(Constants.SERVER_STOP_DELAY);
    }

    /**
     *
     * @param keystore
     * @param passphrase
     * @return
     */
    private SSLContext createSSLContext(String keystore, String passphrase) {
        try{
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream(keystore), passphrase.toCharArray());

            Certificate cert = keyStore.getCertificate("alias");
            System.out.println(cert);
            // Create key manager
            KeyManagerFactory keyManagerFactory = KeyManagerFactory
                    .getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keyStore, passphrase.toCharArray());
            KeyManager[] keyManagers = keyManagerFactory.getKeyManagers();

            // Create trust manager
            TrustManagerFactory trustManagerFactory = TrustManagerFactory
                    .getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            // Initialize SSLContext
            SSLContext sslContext = SSLContext.getInstance("TLSv1");
            sslContext.init(keyManagers, trustManagers, null);

            return sslContext;
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    /**
     *
     * @param port
     * @return
     */
    private HttpsServer createSSLServer(int port)  {
        try {

            HttpsServer server = HttpsServer.create(new InetSocketAddress(port), 0);
            server.setHttpsConfigurator(new HttpsConfigurator(createSSLContext(_keyStore, _keyStorePassword)) {
                @Override
                public void configure(HttpsParameters httpsParameters) {
                    try {
                        // initialise the SSL context
                        SSLContext c = getSSLContext();
                        SSLEngine engine = c.createSSLEngine();
                        httpsParameters.setNeedClientAuth(false);
                        httpsParameters.setCipherSuites(engine.getEnabledCipherSuites());
                        httpsParameters.setProtocols(engine.getEnabledProtocols());
                        // get the default parameters
                        SSLParameters defaultSSLParameters = c.getDefaultSSLParameters();
                        httpsParameters.setSSLParameters(defaultSSLParameters);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            server.setExecutor(null); // todo add executor
            server.createContext("/", new OAuthHandler());
            return server;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
