package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "taxCategoryID",
    "discountID",
    "customerTypeID"
})
public class CustomerType {

    @JsonProperty("name")
    private String name;
    @JsonProperty("taxCategoryID")
    private String taxCategoryID;
    @JsonProperty("discountID")
    private String discountID;
    @JsonProperty("customerTypeID")
    private String customerTypeID;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("taxCategoryID")
    public String getTaxCategoryID() {
        return taxCategoryID;
    }

    @JsonProperty("taxCategoryID")
    public void setTaxCategoryID(String taxCategoryID) {
        this.taxCategoryID = taxCategoryID;
    }

    @JsonProperty("discountID")
    public String getDiscountID() {
        return discountID;
    }

    @JsonProperty("discountID")
    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    @JsonProperty("customerTypeID")
    public String getCustomerTypeID() {
        return customerTypeID;
    }

    @JsonProperty("customerTypeID")
    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(taxCategoryID).append(discountID).append(customerTypeID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerType) == false) {
            return false;
        }
        CustomerType rhs = ((CustomerType) other);
        return new EqualsBuilder().append(name, rhs.name).append(taxCategoryID, rhs.taxCategoryID).append(discountID, rhs.discountID).append(customerTypeID, rhs.customerTypeID).isEquals();
    }

}
