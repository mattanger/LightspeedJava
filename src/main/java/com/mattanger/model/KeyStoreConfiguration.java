package com.mattanger.model;

public class KeyStoreConfiguration {
    private String keyStorePath;
    private String keyStorePassword;
    private String keyManagerPassword;

    public KeyStoreConfiguration(String keyStorePath, String keyStorePassword, String keyManagerPassword) {
        this.keyStorePath = keyStorePath;
        this.keyStorePassword = keyStorePassword;
        this.keyManagerPassword = keyManagerPassword;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public String getKeyManagerPassword() {
        return keyManagerPassword;
    }
}
