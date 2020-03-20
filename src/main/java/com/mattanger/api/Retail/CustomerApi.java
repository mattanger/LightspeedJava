package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.request.GetCustomerRequest;
import com.mattanger.api.Retail.response.GetCustomerResponse;

import java.io.IOException;

public class CustomerApi extends RetailApi {

    /**
     *
     * @param requestFactory
     */
    public CustomerApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "Customer");
    }

    /**
     *
     * @param getCategoryRequest
     * @return
     */
    public GetCustomerResponse getCustomer(GetCustomerRequest getCustomerRequest) throws IOException {
        HttpRequest request = buildGetRequest(getCustomerRequest);
        String response = request.execute().parseAsString();
        return this.objectMapper.readValue(response, GetCustomerResponse.class);
    }
}
