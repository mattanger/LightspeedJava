package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ContactAddress"
})
public class Addresses {

    @JsonProperty("ContactAddress")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ContactAddress> contactAddress;

    @JsonProperty("ContactAddress")
    public List<ContactAddress> getContactAddress() {
        return contactAddress;
    }

    @JsonProperty("ContactAddress")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setContactAddress(List<ContactAddress> contactAddress) {
        this.contactAddress = contactAddress;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contactAddress).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Addresses) == false) {
            return false;
        }
        Addresses rhs = ((Addresses) other);
        return new EqualsBuilder().append(contactAddress, rhs.contactAddress).isEquals();
    }

}
