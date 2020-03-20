package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.Item;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

public class GetItemResponse extends ApiGetResponse {

    @JsonProperty("Item")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<Item> Item;

    @JsonProperty("Item")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<com.mattanger.api.Retail.model.Item> getItem() {
        return Item;
    }

    @JsonProperty("Item")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setItem(List<com.mattanger.api.Retail.model.Item> item) {
        Item = item;
    }
}
