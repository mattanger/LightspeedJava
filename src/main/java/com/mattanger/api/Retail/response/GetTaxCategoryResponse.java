package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.TaxCategory;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetTaxCategoryResponse extends ApiGetResponse {

    @JsonProperty("TaxCategory")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<TaxCategory>  taxCategory;

    @JsonProperty("TaxCategory")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<TaxCategory> getTaxCategory() {
        return taxCategory;
    }
    @JsonProperty("TaxCategory")
    public void setTaxCategory(List<TaxCategory> taxCategory) {
        this.taxCategory = taxCategory;
    }
}
