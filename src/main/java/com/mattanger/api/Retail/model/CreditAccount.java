package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "creditAccountID",
    "balance",
    "creditLimit",
    "timeStamp"
})
public class CreditAccount {

    @JsonProperty("creditAccountID")
    private String creditAccountID;
    @JsonProperty("balance")
    private String balance;
    @JsonProperty("creditLimit")
    private String creditLimit;
    @JsonProperty("timeStamp")
    private String timeStamp;

    @JsonProperty("creditAccountID")
    public String getCreditAccountID() {
        return creditAccountID;
    }

    @JsonProperty("creditAccountID")
    public void setCreditAccountID(String creditAccountID) {
        this.creditAccountID = creditAccountID;
    }

    @JsonProperty("balance")
    public String getBalance() {
        return balance;
    }

    @JsonProperty("balance")
    public void setBalance(String balance) {
        this.balance = balance;
    }

    @JsonProperty("creditLimit")
    public String getCreditLimit() {
        return creditLimit;
    }

    @JsonProperty("creditLimit")
    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
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
        return new HashCodeBuilder().append(creditAccountID).append(balance).append(creditLimit).append(timeStamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditAccount) == false) {
            return false;
        }
        CreditAccount rhs = ((CreditAccount) other);
        return new EqualsBuilder().append(creditAccountID, rhs.creditAccountID).append(balance, rhs.balance).append(creditLimit, rhs.creditLimit).append(timeStamp, rhs.timeStamp).isEquals();
    }

}
