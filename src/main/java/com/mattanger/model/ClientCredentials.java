package com.mattanger.model;

public class ClientCredentials {
    private String clientId;
    private String clientSecret;
    private String[] scopes;
    private String accessTokenUrl;
    private String authenticationServerUrl;


    public ClientCredentials(Builder builder) {
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        this.scopes = builder.scopes;
        this.accessTokenUrl = builder.accessTokenUrl;
        this.authenticationServerUrl = builder.authenticationServerUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String[] getScopes() {
        return scopes;
    }

    public String getAccessTokenUrl() {
        return accessTokenUrl;
    }

    public String getAuthenticationServerUrl() {
        return authenticationServerUrl;
    }

    public static final class Builder {
        private String clientId;
        private String clientSecret;
        private String[] scopes;
        private String accessTokenUrl;
        private String authenticationServerUrl;

        public Builder setClientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        public Builder setScopes(String[] scopes) {
            this.scopes = scopes;
            return this;
        }

        public Builder setAccessTokenUrl(String accessTokenUrl) {
            this.accessTokenUrl = accessTokenUrl;
            return this;
        }

        public Builder setAuthenticationServerUrl(String authenticationServerUrl) {
            this.authenticationServerUrl = authenticationServerUrl;
            return this;
        }

        public ClientCredentials build() {
            return new ClientCredentials(this);
        }
    }
}
