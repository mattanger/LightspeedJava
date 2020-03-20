package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "amount",
    "useTypeID",
    "useType"
})
public class ItemPrice {

    @JsonProperty("amount")
    private String amount;
    @JsonProperty("useTypeID")
    private String useTypeID;
    @JsonProperty("useType")
    private String useType;

    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(String amount) {
        this.amount = amount;
    }

    @JsonProperty("useTypeID")
    public String getUseTypeID() {
        return useTypeID;
    }

    @JsonProperty("useTypeID")
    public void setUseTypeID(String useTypeID) {
        this.useTypeID = useTypeID;
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
        return new HashCodeBuilder().append(amount).append(useTypeID).append(useType).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemPrice) == false) {
            return false;
        }
        ItemPrice rhs = ((ItemPrice) other);
        return new EqualsBuilder().append(amount, rhs.amount).append(useTypeID, rhs.useTypeID).append(useType, rhs.useType).isEquals();
    }

}
