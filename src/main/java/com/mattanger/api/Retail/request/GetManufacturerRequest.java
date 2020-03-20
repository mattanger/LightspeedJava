package com.mattanger.api.Retail.request;

import com.mattanger.api.model.ApiGetRequest;

public class GetManufacturerRequest extends ApiGetRequest {

    public GetManufacturerRequest(Builder<?> builder) {
        super(builder);
    }

    public static Builder<GetManufacturerRequest> builder() {
        return new Builder<GetManufacturerRequest>() {
            @Override
            public GetManufacturerRequest build() {
                return new GetManufacturerRequest(this);
            }
        };
    }
}
