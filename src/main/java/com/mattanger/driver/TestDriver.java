package com.mattanger.driver;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.Constants;
import com.mattanger.LightspeedAuth;
import com.mattanger.api.Retail.request.GetItemRequest;
import com.mattanger.api.Retail.response.GetItemResponse;
import com.mattanger.api.Retail.ItemApi;
import com.mattanger.model.ClientCredentials;
import com.mattanger.model.KeyStoreConfiguration;
import org.apache.commons.cli.*;

public class TestDriver {

    public static void main(String[] args) {
        String[] scopes = {
           "employee:inventory"
        };

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;
        Options options = buildOptions();
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }
        if (cmd == null) {
            System.err.println("No options parsed?");
            System.exit(1);
        }

        ClientCredentials clientCredientials = new ClientCredentials.Builder()
                .setClientId(cmd.getOptionValue("clientId"))
                .setClientSecret(cmd.getOptionValue("clientSecret"))
                .setScopes(scopes)
                .setAccessTokenUrl(Constants.ACCESS_TOKEN_URL)
                .setAuthenticationServerUrl(Constants.AUTH_SERVER_URL)
                .build();
        Credential credential;

        try {
            LightspeedAuth.initialize(Constants.DATA_STORE_DIR);
            credential =  LightspeedAuth.authorize(clientCredientials,
                    new KeyStoreConfiguration(cmd.getOptionValue("keystore"),
                            cmd.getOptionValue("keystore-pwd"),
                            cmd.getOptionValue("keystore-pwd")));
            HttpRequestFactory requestFactory = LightspeedAuth.httpRequestFactory(credential);

            ItemApi itemApi = new ItemApi(requestFactory);
            GetItemResponse response = itemApi.getItem(GetItemRequest.builder()
                    .withExtraParam("itemID", null, "1")
                    .withLoadRelations("all")
                    .withAccountId(134580)
                    .build());
            System.out.println("finish");
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Options buildOptions() {
        final Options opts = new Options();
        Option clientId = new Option("clientId", true, "Lightspeed API client ID.");
        clientId.setRequired(true);
        Option clientSecret = new Option("clientSecret", true, "Lightspeed API client secret.");
        clientId.setRequired(true);
        Option keyStore = new Option("keystore", true, "Path to the local keystore.");
        Option keyStorePwd = new Option("keystore-pwd", true, "Password for the keystore.");
        opts.addOption(clientId);
        opts.addOption(clientSecret);
        opts.addOption(keyStore);
        opts.addOption(keyStorePwd);
        return opts;
    }
}
