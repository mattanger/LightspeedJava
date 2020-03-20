package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "discountID",
        "name",
        "discountAmount",
        "discountPercent",
        "requireCustomer",
        "archived",
        "timeStamp"
})
public class Discount {
    @JsonProperty("discountID")
    private int discountID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("discountAmount")
    private Float discountAmount;
    @JsonProperty("discountPercent")
    private Float discountPercent;
    @JsonProperty("requireCustomer")
    private boolean requireCustomer;
    @JsonProperty("archived")
    private boolean archived;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("discountID")
    public int getDiscountID() {
        return discountID;
    }
    @JsonProperty("discountID")
    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }
    @JsonProperty("discountPercent")
    public Float getDiscountPercent() {
        return discountPercent;
    }
    @JsonProperty("discountPercent")
    public void setDiscountPercent(Float discountPercent) {
        this.discountPercent = discountPercent;
    }
    @JsonProperty("requireCustomer")
    public boolean isRequireCustomer() {
        return requireCustomer;
    }
    @JsonProperty("requireCustomer")
    public void setRequireCustomer(boolean requireCustomer) {
        this.requireCustomer = requireCustomer;
    }
    @JsonProperty("archived")
    public boolean getArchived() {
        return archived;
    }
    @JsonProperty("archived")
    public void setArchived(boolean archived) {
        this.archived = archived;
    }
    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }
    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    @JsonProperty("discountAmount")
    public Float getDiscountAmount() {
        return discountAmount;
    }
    @JsonProperty("discountAmount")
    public void setDiscountAmount(Float discountAmount) {
        this.discountAmount = discountAmount;
    }
}
