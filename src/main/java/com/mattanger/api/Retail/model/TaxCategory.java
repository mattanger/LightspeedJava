package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxCategoryID",
    "isTaxInclusive",
    "tax1Name",
    "tax2Name",
    "tax1Rate",
    "tax2Rate",
    "timeStamp"
})
public class TaxCategory {

    @JsonProperty("taxCategoryID")
    private String taxCategoryID;
    @JsonProperty("isTaxInclusive")
    private String isTaxInclusive;
    @JsonProperty("tax1Name")
    private String tax1Name;
    @JsonProperty("tax2Name")
    private String tax2Name;
    @JsonProperty("tax1Rate")
    private String tax1Rate;
    @JsonProperty("tax2Rate")
    private String tax2Rate;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("isTaxInclusive")
    public String getIsTaxInclusive() {
        return isTaxInclusive;
    }
    @JsonProperty("isTaxInclusive")
    public void setIsTaxInclusive(String isTaxInclusive) {
        this.isTaxInclusive = isTaxInclusive;
    }

    @JsonProperty("tax1Name")
    public String getTax1Name() {
        return tax1Name;
    }

    @JsonProperty("tax1Name")
    public void setTax1Name(String tax1Name) {
        this.tax1Name = tax1Name;
    }

    @JsonProperty("tax2Name")
    public String getTax2Name() {
        return tax2Name;
    }

    @JsonProperty("tax2Name")
    public void setTax2Name(String tax2Name) {
        this.tax2Name = tax2Name;
    }

    @JsonProperty("tax1Rate")
    public String getTax1Rate() {
        return tax1Rate;
    }

    @JsonProperty("tax1Rate")
    public void setTax1Rate(String tax1Rate) {
        this.tax1Rate = tax1Rate;
    }

    @JsonProperty("tax2Rate")
    public String getTax2Rate() {
        return tax2Rate;
    }

    @JsonProperty("tax2Rate")
    public void setTax2Rate(String tax2Rate) {
        this.tax2Rate = tax2Rate;
    }

    @JsonProperty("taxCategoryID")
    public String getTaxCategoryID() {
        return taxCategoryID;
    }

    @JsonProperty("taxCategoryID")
    public void setTaxCategoryID(String taxCategoryID) {
        this.taxCategoryID = taxCategoryID;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tax1Name).append(tax2Name).append(tax1Rate).append(tax2Rate).append(taxCategoryID).append(timeStamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxCategory) == false) {
            return false;
        }
        TaxCategory rhs = ((TaxCategory) other);
        return new EqualsBuilder().append(tax1Name, rhs.tax1Name).append(tax2Name, rhs.tax2Name).append(tax1Rate, rhs.tax1Rate).append(tax2Rate, rhs.tax2Rate).append(taxCategoryID, rhs.taxCategoryID).append(timeStamp, rhs.timeStamp).isEquals();
    }

}
