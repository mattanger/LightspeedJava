package com.mattanger.api.Retail.request;
import com.mattanger.api.ApiQueryValue;
import com.mattanger.api.model.ApiGetRequest;

import java.util.HashMap;

/**
 *
 */
public class GetCategoryRequest extends ApiGetRequest {

    /**
     *
     * @param builder
     */
    protected GetCategoryRequest(Builder<?> builder) {
        super(builder);
    }


    public abstract static class Builder<T extends GetCategoryRequest> extends ApiGetRequest.Builder<T> { }

    public static Builder<GetCategoryRequest> builder() {
        return new Builder<GetCategoryRequest>() {
            @Override
            public GetCategoryRequest build() {
                return new GetCategoryRequest(this);
            }
        };
    }
}
