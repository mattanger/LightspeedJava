package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "itemAttributeSetID",
    "name",
    "attributeName1",
    "attributeName2",
    "attributeName3",
    "system",
    "archived"
})
public class ItemAttributeSet {

    @JsonProperty("itemAttributeSetID")
    private String itemAttributeSetID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("attributeName1")
    private String attributeName1;
    @JsonProperty("attributeName2")
    private String attributeName2;
    @JsonProperty("attributeName3")
    private String attributeName3;
    @JsonProperty("system")
    private String system;
    @JsonProperty("archived")
    private String archived;

    @JsonProperty("itemAttributeSetID")
    public String getItemAttributeSetID() {
        return itemAttributeSetID;
    }

    @JsonProperty("itemAttributeSetID")
    public void setItemAttributeSetID(String itemAttributeSetID) {
        this.itemAttributeSetID = itemAttributeSetID;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("attributeName1")
    public String getAttributeName1() {
        return attributeName1;
    }

    @JsonProperty("attributeName1")
    public void setAttributeName1(String attributeName1) {
        this.attributeName1 = attributeName1;
    }

    @JsonProperty("attributeName2")
    public String getAttributeName2() {
        return attributeName2;
    }

    @JsonProperty("attributeName2")
    public void setAttributeName2(String attributeName2) {
        this.attributeName2 = attributeName2;
    }

    @JsonProperty("attributeName3")
    public String getAttributeName3() {
        return attributeName3;
    }

    @JsonProperty("attributeName3")
    public void setAttributeName3(String attributeName3) {
        this.attributeName3 = attributeName3;
    }

    @JsonProperty("system")
    public String getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(String system) {
        this.system = system;
    }

    @JsonProperty("archived")
    public String getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(String archived) {
        this.archived = archived;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemAttributeSetID).append(name).append(attributeName1).append(attributeName2).append(attributeName3).append(system).append(archived).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ItemAttributeSet) == false) {
            return false;
        }
        ItemAttributeSet rhs = ((ItemAttributeSet) other);
        return new EqualsBuilder().append(itemAttributeSetID, rhs.itemAttributeSetID).append(name, rhs.name).append(attributeName1, rhs.attributeName1).append(attributeName2, rhs.attributeName2).append(attributeName3, rhs.attributeName3).append(system, rhs.system).append(archived, rhs.archived).isEquals();
    }

}
