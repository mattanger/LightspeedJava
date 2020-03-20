package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.request.GetCategoryRequest;
import com.mattanger.api.Retail.response.GetCategoryResponse;

import java.io.IOException;

/**
 *
 */
public class CategoryApi extends RetailApi {

    /**
     *
     * @param requestFactory
     * @param endpoint
     */
    public CategoryApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "Category");
    }

    /**
     *
     * @param getCategoryRequest
     * @return
     * @throws IOException
     */
    public GetCategoryResponse getCategories(GetCategoryRequest getCategoryRequest) throws IOException {
        HttpRequest request = buildGetRequest(getCategoryRequest);
        String response = request.execute().parseAsString();
        return this.objectMapper.readValue(response, GetCategoryResponse.class);
    }
}
