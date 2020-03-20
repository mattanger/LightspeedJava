package com.mattanger.old;

import com.mattanger.model.ClientCredentials;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class LightspeedOAuthClient {


    private static final String TEMP_TOKEN_URL
            = "https://cloud.merchantos.com/oauth/authorize.php?response_type=code&client_id=%s&scope=%s";


    public static void Authorize(ClientCredentials credentials) {
//        try {
//            String scopes = URLEncoder.encode(String.join("+", credentials.get_scopes()));
//            String url = String.format(TEMP_TOKEN_URL, credentials.get_clientId(), scopes);
//            Desktop.getDesktop().browse(new URI(url));
//
//
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }

    }




}
