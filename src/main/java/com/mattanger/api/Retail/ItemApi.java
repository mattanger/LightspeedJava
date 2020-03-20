package com.mattanger.api.Retail;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.api.Retail.request.GetItemRequest;
import com.mattanger.api.Retail.response.GetItemResponse;
import com.mattanger.api.Retail.request.UpdateItemRequest;
import com.mattanger.api.Retail.response.UpdateItemResponse;

import java.io.IOException;

public class ItemApi extends RetailApi {

    public ItemApi(HttpRequestFactory requestFactory) {
        super(requestFactory, "Item");
    }

    public GetItemResponse getItem(GetItemRequest getItemRequest) throws IOException {
        HttpRequest request = buildGetRequest(getItemRequest);
        String response = request.execute().parseAsString();
        GetItemResponse getItemResponse = this.objectMapper.readValue(response, GetItemResponse.class);
        return getItemResponse;
    }

    public UpdateItemResponse updateItem(UpdateItemRequest updateItemRequest) {
        return null;
    }

}
