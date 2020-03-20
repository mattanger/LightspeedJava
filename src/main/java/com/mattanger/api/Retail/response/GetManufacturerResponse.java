package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.Manufacturer;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

public class GetManufacturerResponse extends ApiGetResponse {

    @JsonProperty("Manufacturer")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<Manufacturer> manufacturer;

    @JsonProperty("Manufacturer")
    public List<Manufacturer> getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("Manufacturer")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setManufacturer(List<Manufacturer> manufacturer) {
        this.manufacturer = manufacturer;
    }

}
