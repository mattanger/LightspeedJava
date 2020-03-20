package com.mattanger.api;

import com.google.api.client.http.GenericUrl;

public class ApiUrl extends GenericUrl {

    public ApiUrl(String encodedUrl) {
        super(encodedUrl);
    }
}
