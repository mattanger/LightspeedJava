package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.Vendor;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

public class GetVendorResponse extends ApiGetResponse {

    @JsonProperty("Vendor")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Vendor> vendor;

    @JsonProperty("Vendor")
    public List<Vendor> getVendor() {
        return vendor;
    }

    @JsonProperty("Vendor")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setVendor(List<Vendor> vendor) {
        this.vendor = vendor;
    }
}
