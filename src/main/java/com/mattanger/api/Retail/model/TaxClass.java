package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxClassID",
    "name",
    "timeStamp"
})
public class TaxClass {

    @JsonProperty("taxClassID")
    private String taxClassID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("timeStamp")
    private String timeStamp;

    @JsonProperty("taxClassID")
    public String getTaxClassID() {
        return taxClassID;
    }

    @JsonProperty("taxClassID")
    public void setTaxClassID(String taxClassID) {
        this.taxClassID = taxClassID;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
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
        return new HashCodeBuilder().append(taxClassID).append(name).append(timeStamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxClass) == false) {
            return false;
        }
        TaxClass rhs = ((TaxClass) other);
        return new EqualsBuilder().append(taxClassID, rhs.taxClassID).append(name, rhs.name).append(timeStamp, rhs.timeStamp).isEquals();
    }

}
