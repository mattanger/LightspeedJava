package com.mattanger.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.w3c.dom.Attr;

import java.util.List;

public class ApiGetResponse {
    @JsonProperty("@attributes")
    public Attributes attributes;


    @JsonProperty("@attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("@attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
