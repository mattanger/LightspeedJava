package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "VendorRep"
})
public class Reps {

    @JsonProperty("VendorRep")
    private VendorRep vendorRep;

    @JsonProperty("VendorRep")
    public VendorRep getVendorRep() {
        return vendorRep;
    }

    @JsonProperty("VendorRep")
    public void setVendorRep(VendorRep vendorRep) {
        this.vendorRep = vendorRep;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(vendorRep).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Reps) == false) {
            return false;
        }
        Reps rhs = ((Reps) other);
        return new EqualsBuilder().append(vendorRep, rhs.vendorRep).isEquals();
    }

}
