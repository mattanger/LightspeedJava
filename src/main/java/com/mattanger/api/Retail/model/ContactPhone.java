package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "number",
    "useType"
})
public class ContactPhone {

    @JsonProperty("number")
    private String number;
    @JsonProperty("useType")
    private String useType;

    @JsonProperty("number")
    public String getNumber() {
        return number;
    }

    @JsonProperty("number")
    public void setNumber(String number) {
        this.number = number;
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
        return new HashCodeBuilder().append(number).append(useType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContactPhone) == false) {
            return false;
        }
        ContactPhone rhs = ((ContactPhone) other);
        return new EqualsBuilder().append(number, rhs.number).append(useType, rhs.useType).isEquals();
    }

}
