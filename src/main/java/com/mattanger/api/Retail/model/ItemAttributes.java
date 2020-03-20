package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attribute1",
    "attribute2",
    "attribute3",
    "itemAttributeSetID",
    "ItemAttributeSet"
})
public class ItemAttributes {

    @JsonProperty("attribute1")
    private String attribute1;
    @JsonProperty("attribute2")
    private String attribute2;
    @JsonProperty("attribute3")
    private String attribute3;
    @JsonProperty("itemAttributeSetID")
    private String itemAttributeSetID;
    @JsonProperty("ItemAttributeSet")
    private ItemAttributeSet itemAttributeSet;

    @JsonProperty("attribute1")
    public String getAttribute1() {
        return attribute1;
    }

    @JsonProperty("attribute1")
    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    @JsonProperty("attribute2")
    public String getAttribute2() {
        return attribute2;
    }

    @JsonProperty("attribute2")
    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    @JsonProperty("attribute3")
    public String getAttribute3() {
        return attribute3;
    }

    @JsonProperty("attribute3")
    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }

    @JsonProperty("itemAttributeSetID")
    public String getItemAttributeSetID() {
        return itemAttributeSetID;
    }

    @JsonProperty("itemAttributeSetID")
    public void setItemAttributeSetID(String itemAttributeSetID) {
        this.itemAttributeSetID = itemAttributeSetID;
    }

    @JsonProperty("ItemAttributeSet")
    public ItemAttributeSet getItemAttributeSet() {
        return itemAttributeSet;
    }

    @JsonProperty("ItemAttributeSet")
    public void setItemAttributeSet(ItemAttributeSet itemAttributeSet) {
        this.itemAttributeSet = itemAttributeSet;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attribute1).append(attribute2).append(attribute3).append(itemAttributeSetID).append(itemAttributeSet).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemAttributes) == false) {
            return false;
        }
        ItemAttributes rhs = ((ItemAttributes) other);
        return new EqualsBuilder().append(attribute1, rhs.attribute1).append(attribute2, rhs.attribute2).append(attribute3, rhs.attribute3).append(itemAttributeSetID, rhs.itemAttributeSetID).append(itemAttributeSet, rhs.itemAttributeSet).isEquals();
    }

}
