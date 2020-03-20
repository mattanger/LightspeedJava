package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "itemComponentID",
    "quantity",
    "componentGroup",
    "assemblyItemID",
    "componentItemID"
})
public class ItemComponent {

    @JsonProperty("itemComponentID")
    private String itemComponentID;
    @JsonProperty("quantity")
    private String quantity;
    @JsonProperty("componentGroup")
    private String componentGroup;
    @JsonProperty("assemblyItemID")
    private String assemblyItemID;
    @JsonProperty("componentItemID")
    private String componentItemID;

    @JsonProperty("itemComponentID")
    public String getItemComponentID() {
        return itemComponentID;
    }

    @JsonProperty("itemComponentID")
    public void setItemComponentID(String itemComponentID) {
        this.itemComponentID = itemComponentID;
    }

    @JsonProperty("quantity")
    public String getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("componentGroup")
    public String getComponentGroup() {
        return componentGroup;
    }

    @JsonProperty("componentGroup")
    public void setComponentGroup(String componentGroup) {
        this.componentGroup = componentGroup;
    }

    @JsonProperty("assemblyItemID")
    public String getAssemblyItemID() {
        return assemblyItemID;
    }

    @JsonProperty("assemblyItemID")
    public void setAssemblyItemID(String assemblyItemID) {
        this.assemblyItemID = assemblyItemID;
    }

    @JsonProperty("componentItemID")
    public String getComponentItemID() {
        return componentItemID;
    }

    @JsonProperty("componentItemID")
    public void setComponentItemID(String componentItemID) {
        this.componentItemID = componentItemID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemComponentID).append(quantity).append(componentGroup).append(assemblyItemID).append(componentItemID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemComponent) == false) {
            return false;
        }
        ItemComponent rhs = ((ItemComponent) other);
        return new EqualsBuilder().append(itemComponentID, rhs.itemComponentID).append(quantity, rhs.quantity).append(componentGroup, rhs.componentGroup).append(assemblyItemID, rhs.assemblyItemID).append(componentItemID, rhs.componentItemID).isEquals();
    }

}
