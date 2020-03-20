package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "address",
    "useType"
})
public class ContactEmail {

    @JsonProperty("address")
    private String address;
    @JsonProperty("useType")
    private String useType;

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("useType")
    public String getUseType() {
        return useType;
    }

    @JsonProperty("useType")
    public void setUseType(String useType) {
        this.useType = useType;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(address).append(useType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContactEmail) == false) {
            return false;
        }
        ContactEmail rhs = ((ContactEmail) other);
        return new EqualsBuilder().append(address, rhs.address).append(useType, rhs.useType).isEquals();
    }

}
