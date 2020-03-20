package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Item"
})
public class ItemAllRelations {

    @JsonProperty("Item")
    private Item item;

    @JsonProperty("Item")
    public Item getItem() {
        return item;
    }

    @JsonProperty("Item")
    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(item).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemAllRelations) == false) {
            return false;
        }
        ItemAllRelations rhs = ((ItemAllRelations) other);
        return new EqualsBuilder().append(item, rhs.item).isEquals();
    }

}
