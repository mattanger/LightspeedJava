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
    "ContactPhone"
})
public class Phones {

    public Phones() {
    }

    public Phones(String phones) {

    }

    @JsonProperty("ContactPhone")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ContactPhone> contactPhone;

    @JsonProperty("ContactPhone")
    public List<ContactPhone> getContactPhone() {
        return contactPhone;
    }

    @JsonProperty("ContactPhone")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setContactPhone(List<ContactPhone> contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contactPhone).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Phones) == false) {
            return false;
        }
        Phones rhs = ((Phones) other);
        return new EqualsBuilder().append(contactPhone, rhs.contactPhone).isEquals();
    }

}
