package com.mattanger.api.Retail.request;

import com.mattanger.api.model.ApiGetRequest;

public class GetVendorRequest extends ApiGetRequest{
    public GetVendorRequest(Builder<?> builder) {
        super(builder);
    }

    public static Builder<GetVendorRequest> builder() {
        return new Builder<GetVendorRequest>() {
            @Override
            public GetVendorRequest build() {
                return new GetVendorRequest(this);
            }
        };
    }
}
