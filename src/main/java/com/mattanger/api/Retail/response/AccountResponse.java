package com.mattanger.api.Retail.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mattanger.api.model.ApiGetResponse;

import java.util.List;

public class AccountResponse extends ApiGetResponse {

    @JsonProperty("Account")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public List<com.mattanger.api.Retail.model.Account> Account;
}
