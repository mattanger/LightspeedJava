package com.mattanger.api.Retail.request;

import com.mattanger.api.Retail.response.GetCustomerResponse;
import com.mattanger.api.model.ApiGetRequest;

/**
 *
 */
public class GetCustomerRequest extends ApiGetRequest {

    /**
     *
     * @param builder
     */
    protected GetCustomerRequest(Builder<?> builder) {
        super(builder);
    }

    public static Builder<GetCustomerRequest> builder() {
        return new Builder<GetCustomerRequest>() {
            @Override
            public GetCustomerRequest build() {
                return new GetCustomerRequest(this);
            }
        };
    }
}
