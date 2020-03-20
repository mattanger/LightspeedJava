package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.request.GetVendorRequest;
import com.mattanger.api.Retail.response.GetVendorResponse;

import java.io.IOException;

public class VendorApi extends RetailApi {

    public VendorApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "Vendor");
    }

    public GetVendorResponse getVendor(GetVendorRequest getVendorRequest) throws IOException {
        return makeGetRequest(getVendorRequest, GetVendorResponse.class);
    }


}
