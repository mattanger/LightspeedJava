package com.mattanger.api.Retail.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ItemPrice"
})
public class Prices {

    @JsonProperty("ItemPrice")
    private List<ItemPrice> itemPrice = new ArrayList<ItemPrice>();

    @JsonProperty("ItemPrice")
    public List<ItemPrice> getItemPrice() {
        return itemPrice;
    }

    @JsonProperty("ItemPrice")
    public void setItemPrice(List<ItemPrice> itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemPrice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Prices) == false) {
            return false;
        }
        Prices rhs = ((Prices) other);
        return new EqualsBuilder().append(itemPrice, rhs.itemPrice).isEquals();
    }

}
