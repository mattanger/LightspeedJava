package com.mattanger;

public class Constants {
    public static final int LISTEN_PORT = 9191;
    public static final int SERVER_STOP_DELAY = 5;
    public static final String AUTH_SERVER_URL = "https://cloud.merchantos.com/oauth/authorize.php";
    public static final String ACCESS_TOKEN_URL = "https://cloud.merchantos.com/oauth/access_token.php";

    public static final java.io.File DATA_STORE_DIR =
            new java.io.File("store/");
}
