package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.Retail.model.Customer;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

public class GetCustomerResponse extends ApiGetResponse {

    @JsonProperty("Customer")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Customer> customer;

    @JsonProperty("Customer")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @JsonProperty("Customer")
    public List<Customer> getCustomer() {
        return this.customer;
    }

}
