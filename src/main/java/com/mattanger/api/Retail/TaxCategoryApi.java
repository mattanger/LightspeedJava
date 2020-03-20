package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.response.GetTaxCategoryResponse;
import com.mattanger.api.model.ApiGetRequest;

import java.io.IOException;

public class TaxCategoryApi extends RetailApi {
    public TaxCategoryApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "TaxCategory");
    }

    public GetTaxCategoryResponse getTaxCategory(ApiGetRequest getRequest) throws IOException {
        return makeGetRequest(getRequest, GetTaxCategoryResponse.class);
    }

}
