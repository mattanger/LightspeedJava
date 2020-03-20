package com.mattanger.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {
    @JsonProperty("@attributes")
    public Attributes attributes;
}
