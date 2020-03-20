package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "categoryID",
    "name",
    "nodeDepth",
    "fullPathName",
    "leftNode",
    "rightNode",
    "createTime",
    "timeStamp",
    "parentID"
})
public class Category {

    @JsonProperty("categoryID")
    private String categoryID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nodeDepth")
    private String nodeDepth;
    @JsonProperty("fullPathName")
    private String fullPathName;
    @JsonProperty("leftNode")
    private String leftNode;
    @JsonProperty("rightNode")
    private String rightNode;
    @JsonProperty("createTime")
    private String createTime;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("parentID")
    private String parentID;

    @JsonProperty("categoryID")
    public String getCategoryID() {
        return categoryID;
    }

    @JsonProperty("categoryID")
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nodeDepth")
    public String getNodeDepth() {
        return nodeDepth;
    }

    @JsonProperty("nodeDepth")
    public void setNodeDepth(String nodeDepth) {
        this.nodeDepth = nodeDepth;
    }

    @JsonProperty("fullPathName")
    public String getFullPathName() {
        return fullPathName;
    }

    @JsonProperty("fullPathName")
    public void setFullPathName(String fullPathName) {
        this.fullPathName = fullPathName;
    }

    @JsonProperty("leftNode")
    public String getLeftNode() {
        return leftNode;
    }

    @JsonProperty("leftNode")
    public void setLeftNode(String leftNode) {
        this.leftNode = leftNode;
    }

    @JsonProperty("rightNode")
    public String getRightNode() {
        return rightNode;
    }

    @JsonProperty("rightNode")
    public void setRightNode(String rightNode) {
        this.rightNode = rightNode;
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

    @JsonProperty("parentID")
    public String getParentID() {
        return parentID;
    }

    @JsonProperty("parentID")
    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(categoryID).append(name).append(nodeDepth).append(fullPathName).append(leftNode).append(rightNode).append(createTime).append(timeStamp).append(parentID).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category) == false) {
            return false;
        }
        Category rhs = ((Category) other);
        return new EqualsBuilder().append(categoryID, rhs.categoryID).append(name, rhs.name).append(nodeDepth, rhs.nodeDepth).append(fullPathName, rhs.fullPathName).append(leftNode, rhs.leftNode).append(rightNode, rhs.rightNode).append(createTime, rhs.createTime).append(timeStamp, rhs.timeStamp).append(parentID, rhs.parentID).isEquals();
    }

}
