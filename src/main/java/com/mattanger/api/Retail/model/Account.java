package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.api.client.util.Key;
import com.mattanger.api.model.Attributes;
import com.mattanger.api.model.Link;

public class Account {

    @JsonProperty("accountID")
    public int accountID;

    @JsonProperty("name")
    public String name;

    @JsonProperty("link")
    public Link link;
}
