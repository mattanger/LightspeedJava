package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "manufacturerID",
    "name",
    "createTime",
    "timeStamp"
})
public class Manufacturer {

    @JsonProperty("manufacturerID")
    private String manufacturerID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createTime")
    private String createTime;
    @JsonProperty("timeStamp")
    private String timeStamp;

    @JsonProperty("manufacturerID")
    public String getManufacturerID() {
        return manufacturerID;
    }

    @JsonProperty("manufacturerID")
    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("createTime")
    public String getCreateTime() {
        return createTime;
    }

    @JsonProperty("createTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
        return new HashCodeBuilder().append(manufacturerID).append(name).append(createTime).append(timeStamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Manufacturer) == false) {
            return false;
        }
        Manufacturer rhs = ((Manufacturer) other);
        return new EqualsBuilder().append(manufacturerID, rhs.manufacturerID).append(name, rhs.name).append(createTime, rhs.createTime).append(timeStamp, rhs.timeStamp).isEquals();
    }

}
