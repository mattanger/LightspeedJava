package com.mattanger.api.Retail.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@attributes",
    "Customer"
})
public class CustomerAll {

    @JsonProperty("@attributes")
    private Attributes attributes;
    @JsonProperty("Customer")
    private List<Customer> customer = new ArrayList<Customer>();

    @JsonProperty("@attributes")
    public Attributes getAttributes() {
        return attributes;
    }

    @JsonProperty("@attributes")
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @JsonProperty("Customer")
    public List<Customer> getCustomer() {
        return customer;
    }

    @JsonProperty("Customer")
    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attributes).append(customer).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerAll) == false) {
            return false;
        }
        CustomerAll rhs = ((CustomerAll) other);
        return new EqualsBuilder().append(attributes, rhs.attributes).append(customer, rhs.customer).isEquals();
    }

}
