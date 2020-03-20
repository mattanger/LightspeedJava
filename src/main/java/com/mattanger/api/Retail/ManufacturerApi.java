package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.request.GetManufacturerRequest;
import com.mattanger.api.Retail.response.GetManufacturerResponse;

import java.io.IOException;

public class ManufacturerApi extends RetailApi {
    public ManufacturerApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "Manufacturer");
    }

    public GetManufacturerResponse getManufacturer(GetManufacturerRequest getManufacturerRequest) throws IOException {
        return makeGetRequest(getManufacturerRequest, GetManufacturerResponse.class);
    }
}
