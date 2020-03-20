package com.mattanger.api.Retail;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.model.ApiGetRequest;
import com.mattanger.api.model.ApiGetResponse;

import java.io.IOException;

public abstract class RetailApi {

    private static final String BASE_URL = "https://api.merchantos.com/API/Account/";
    private String endpoint;
    private HttpRequestFactory requestFactory;
    protected ObjectMapper objectMapper;

    RetailApi(HttpRequestFactory requestFactory, String endpoint) {
        this.requestFactory = requestFactory;
        this.endpoint = endpoint.replaceAll("/", "");
        this.objectMapper = new ObjectMapper();
    }

    HttpRequest buildGetRequest(ApiGetRequest getRequest) throws IOException {
        GenericUrl url = new GenericUrl(buildUrlString(getRequest.getAccountId()));
        url.putAll(getRequest.buildQueryParams());
        System.out.println(url.build());
        return this.requestFactory.buildGetRequest(url);
    }

    protected <T extends ApiGetResponse> T makeGetRequest(ApiGetRequest getRequest, Class respClass) throws IOException {
        HttpRequest request = buildGetRequest(getRequest);
        String response = request.execute().parseAsString();
        return (T) this.objectMapper.readValue(response, respClass);
    }


    protected void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    private String buildUrlString(int accountId) {
        return BASE_URL + accountId + "/" + this.endpoint;
    }
}
