package com.mattanger.api.Retail.request;

import com.mattanger.api.ApiQueryValue;
import com.mattanger.api.model.ApiGetRequest;

import java.util.HashMap;
import java.util.Map;

public class GetItemRequest extends ApiGetRequest {

    protected GetItemRequest(Builder<?> builder) {
        super(builder);
    }

    public static Builder<GetItemRequest> builder() {
        return new Builder<GetItemRequest>() {
            @Override
            public GetItemRequest build() {
                return new GetItemRequest(this);
            }
        };
    }
}
