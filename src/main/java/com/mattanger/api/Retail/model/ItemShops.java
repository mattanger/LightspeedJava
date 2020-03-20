package com.mattanger.api.Retail.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ItemShop"
})
public class ItemShops {

    @JsonProperty("ItemShop")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ItemShop> itemShop = new ArrayList<ItemShop>();

    @JsonProperty("ItemShop")
    public List<ItemShop> getItemShop() {
        return itemShop;
    }

    @JsonProperty("ItemShop")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setItemShop(List<ItemShop> itemShop) {
        this.itemShop = itemShop;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemShop).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemShops) == false) {
            return false;
        }
        ItemShops rhs = ((ItemShops) other);
        return new EqualsBuilder().append(itemShop, rhs.itemShop).isEquals();
    }

}
