package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.response.GetDiscountResponse;
import com.mattanger.api.model.ApiGetRequest;

import java.io.IOException;

public class DiscountApi extends RetailApi {

    public DiscountApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "Discount");
    }

    public GetDiscountResponse getDiscounts(ApiGetRequest getRequest) throws IOException {
        return makeGetRequest(getRequest, GetDiscountResponse.class);
    }

}
