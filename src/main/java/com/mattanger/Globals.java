package com.mattanger;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

public class Globals {
    public static final JsonFactory JSON_FACTORY = new JacksonFactory();
    /** Global instance of the HTTP transport. */
    public static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    public static FileDataStoreFactory DATA_STORE_FACTORY;
}
