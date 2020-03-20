package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.Category;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

public class GetCategoryResponse extends ApiGetResponse {

    @JsonProperty("Category")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Category> category;

    @JsonProperty("Category")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @JsonProperty("Category")
    public List<Category> getCategory() {
        return this.category;
    }

}
