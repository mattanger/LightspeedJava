package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "itemShopID",
    "qoh",
    "backorder",
    "componentQoh",
    "componentBackorder",
    "reorderPoint",
    "reorderLevel",
    "timeStamp",
    "itemID",
    "shopID"
})
public class ItemShop {

    @JsonProperty("itemShopID")
    private String itemShopID;
    @JsonProperty("qoh")
    private String qoh;
    @JsonProperty("backorder")
    private String backorder;
    @JsonProperty("componentQoh")
    private String componentQoh;
    @JsonProperty("componentBackorder")
    private String componentBackorder;
    @JsonProperty("reorderPoint")
    private String reorderPoint;
    @JsonProperty("reorderLevel")
    private String reorderLevel;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("itemID")
    private String itemID;
    @JsonProperty("shopID")
    private String shopID;

    @JsonProperty("itemShopID")
    public String getItemShopID() {
        return itemShopID;
    }

    @JsonProperty("itemShopID")
    public void setItemShopID(String itemShopID) {
        this.itemShopID = itemShopID;
    }

    @JsonProperty("qoh")
    public String getQoh() {
        return qoh;
    }

    @JsonProperty("qoh")
    public void setQoh(String qoh) {
        this.qoh = qoh;
    }

    @JsonProperty("backorder")
    public String getBackorder() {
        return backorder;
    }

    @JsonProperty("backorder")
    public void setBackorder(String backorder) {
        this.backorder = backorder;
    }

    @JsonProperty("componentQoh")
    public String getComponentQoh() {
        return componentQoh;
    }

    @JsonProperty("componentQoh")
    public void setComponentQoh(String componentQoh) {
        this.componentQoh = componentQoh;
    }

    @JsonProperty("componentBackorder")
    public String getComponentBackorder() {
        return componentBackorder;
    }

    @JsonProperty("componentBackorder")
    public void setComponentBackorder(String componentBackorder) {
        this.componentBackorder = componentBackorder;
    }

    @JsonProperty("reorderPoint")
    public String getReorderPoint() {
        return reorderPoint;
    }

    @JsonProperty("reorderPoint")
    public void setReorderPoint(String reorderPoint) {
        this.reorderPoint = reorderPoint;
    }

    @JsonProperty("reorderLevel")
    public String getReorderLevel() {
        return reorderLevel;
    }

    @JsonProperty("reorderLevel")
    public void setReorderLevel(String reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    @JsonProperty("timeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    @JsonProperty("timeStamp")
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @JsonProperty("itemID")
    public String getItemID() {
        return itemID;
    }

    @JsonProperty("itemID")
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @JsonProperty("shopID")
    public String getShopID() {
        return shopID;
    }

    @JsonProperty("shopID")
    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemShopID).append(qoh).append(backorder).append(componentQoh).append(componentBackorder).append(reorderPoint).append(reorderLevel).append(timeStamp).append(itemID).append(shopID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemShop) == false) {
            return false;
        }
        ItemShop rhs = ((ItemShop) other);
        return new EqualsBuilder().append(itemShopID, rhs.itemShopID).append(qoh, rhs.qoh).append(backorder, rhs.backorder).append(componentQoh, rhs.componentQoh).append(componentBackorder, rhs.componentBackorder).append(reorderPoint, rhs.reorderPoint).append(reorderLevel, rhs.reorderLevel).append(timeStamp, rhs.timeStamp).append(itemID, rhs.itemID).append(shopID, rhs.shopID).isEquals();
    }

}
