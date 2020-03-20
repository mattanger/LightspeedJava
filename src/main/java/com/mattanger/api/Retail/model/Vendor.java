package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "vendorID",
    "name",
    "archived",
    "accountNumber",
    "priceLevel",
    "updatePrice",
    "updateCost",
    "updateDescription",
    "shareSellThrough",
    "timeStamp",
    "Contact",
    "Reps"
})
public class Vendor {

    @JsonProperty("vendorID")
    private String vendorID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("archived")
    private String archived;
    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("priceLevel")
    private String priceLevel;
    @JsonProperty("updatePrice")
    private String updatePrice;
    @JsonProperty("updateCost")
    private String updateCost;
    @JsonProperty("updateDescription")
    private String updateDescription;
    @JsonProperty("shareSellThrough")
    private String shareSellThrough;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("Contact")
    private Contact contact;
    @JsonProperty("Reps")
    private Reps reps;

    @JsonProperty("vendorID")
    public String getVendorID() {
        return vendorID;
    }

    @JsonProperty("vendorID")
    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("archived")
    public String getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(String archived) {
        this.archived = archived;
    }

    @JsonProperty("accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("priceLevel")
    public String getPriceLevel() {
        return priceLevel;
    }

    @JsonProperty("priceLevel")
    public void setPriceLevel(String priceLevel) {
        this.priceLevel = priceLevel;
    }

    @JsonProperty("updatePrice")
    public String getUpdatePrice() {
        return updatePrice;
    }

    @JsonProperty("updatePrice")
    public void setUpdatePrice(String updatePrice) {
        this.updatePrice = updatePrice;
    }

    @JsonProperty("updateCost")
    public String getUpdateCost() {
        return updateCost;
    }

    @JsonProperty("updateCost")
    public void setUpdateCost(String updateCost) {
        this.updateCost = updateCost;
    }

    @JsonProperty("updateDescription")
    public String getUpdateDescription() {
        return updateDescription;
    }

    @JsonProperty("updateDescription")
    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    @JsonProperty("shareSellThrough")
    public String getShareSellThrough() {
        return shareSellThrough;
    }

    @JsonProperty("shareSellThrough")
    public void setShareSellThrough(String shareSellThrough) {
        this.shareSellThrough = shareSellThrough;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("Contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("Contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("Reps")
    public Reps getReps() {
        return reps;
    }

    @JsonProperty("Reps")
    public void setReps(Reps reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(vendorID).append(name).append(archived).append(accountNumber).append(priceLevel).append(updatePrice).append(updateCost).append(updateDescription).append(shareSellThrough).append(timeStamp).append(contact).append(reps).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Vendor) == false) {
            return false;
        }
        Vendor rhs = ((Vendor) other);
        return new EqualsBuilder().append(vendorID, rhs.vendorID).append(name, rhs.name).append(archived, rhs.archived).append(accountNumber, rhs.accountNumber).append(priceLevel, rhs.priceLevel).append(updatePrice, rhs.updatePrice).append(updateCost, rhs.updateCost).append(updateDescription, rhs.updateDescription).append(shareSellThrough, rhs.shareSellThrough).append(timeStamp, rhs.timeStamp).append(contact, rhs.contact).append(reps, rhs.reps).isEquals();
    }

}
