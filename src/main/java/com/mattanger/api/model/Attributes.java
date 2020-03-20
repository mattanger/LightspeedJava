package com.mattanger.api.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "count",
        "offset",
        "limit",
        "href"
})
@JsonIgnoreProperties({"systemCustomerID"})
public class Attributes {
    @JsonProperty("count")
    public int count;
    @JsonProperty("offset")
    public int offset;
    @JsonProperty("limit")
    public int limit;
    @JsonProperty("href")
    public String href;

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(count)
                .append(offset)
                .append(limit)
                .append(href)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof com.mattanger.api.model.Attributes) == false) {
            return false;
        }
        com.mattanger.api.model.Attributes rhs = ((com.mattanger.api.model.Attributes) other);
        return new EqualsBuilder().append(count, rhs.count).isEquals();
    }

}
