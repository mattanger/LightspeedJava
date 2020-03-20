package com.mattanger;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.ClientParametersAuthentication;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.http.*;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.mattanger.model.ClientCredentials;
import com.mattanger.model.KeyStoreConfiguration;
import com.mattanger.receiver.LightspeedLocalReceiver;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 */
public class LightspeedAuth {

    private static boolean isInitialized;

    /**
     *
     * @param dataStoreDirectory
     * @throws IOException
     */
    public static void initialize(File dataStoreDirectory) throws IOException {
        Globals.DATA_STORE_FACTORY = new FileDataStoreFactory(dataStoreDirectory);
        isInitialized = true;
    }

    /**
     *
     * @param credential
     * @return
     * @throws IOException
     */
    public static HttpRequestFactory httpRequestFactory(final Credential credential) throws IOException {
        HttpRequestFactory factory = Globals.HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
                credential.initialize(request);
                request.setParser(new JsonObjectParser(Globals.JSON_FACTORY));
                request.getHeaders().setAccept("application/json");
            }
        });
        return factory;
    }

    /**
     *
     * @param accessToken
     * @return
     * @throws IOException
     */
    public static HttpRequestFactory httpRequestFactory(String accessToken) throws IOException {
        HttpRequestFactory factory = Globals.HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest request) throws IOException {
                request.setParser(new JsonObjectParser(Globals.JSON_FACTORY));
                request.getHeaders().setAuthorization("Bearer " + accessToken);
                request.getHeaders().setAccept("application/json");
            }
        });
        return factory;
    }

    /**
     *
     * @param credentials
     * @param keyStoreConfiguration
     * @return
     * @throws Exception
     */
    public static Credential authorize(ClientCredentials credentials, KeyStoreConfiguration keyStoreConfiguration)
            throws Exception {
        if (!isInitialized)
            throw new Exception("Authenticator has not been initialized! Execute initialize()!");

        AuthorizationCodeFlow flow = new AuthorizationCodeFlow.Builder(BearerToken
                .authorizationHeaderAccessMethod(),
                Globals.HTTP_TRANSPORT,
                Globals.JSON_FACTORY,
                new GenericUrl(credentials.getAccessTokenUrl()),
                new ClientParametersAuthentication(
                        credentials.getClientId(),
                        credentials.getClientSecret()),
                credentials.getClientId(),
                credentials.getAuthenticationServerUrl())
                .setScopes(Arrays.asList(credentials.getScopes()))
                .setDataStoreFactory(Globals.DATA_STORE_FACTORY).build();
        // authorize
        LightspeedLocalReceiver receiver = new LightspeedLocalReceiver.Builder().setHost(
                "localhost")
                .setPort(9191)
                .setProtocol("https")
                .setKeyStorePath(keyStoreConfiguration)
                .build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
}
