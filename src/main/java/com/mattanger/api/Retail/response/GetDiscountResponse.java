package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.Discount;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetDiscountResponse extends ApiGetResponse {
    @JsonProperty("Discount")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Discount> discounts;
    @JsonProperty("Discount")
    public List<Discount> getDiscounts() {
        return discounts;
    }
    @JsonProperty("Discount")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }
}
