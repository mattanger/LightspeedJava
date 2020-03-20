package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "note",
    "isPublic",
    "timeStamp"
})
public class Note {

    @JsonProperty("note")
    private String note;
    @JsonProperty("isPublic")
    private String isPublic;
    @JsonProperty("timeStamp")
    private String timeStamp;

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
    }

    @JsonProperty("isPublic")
    public String getIsPublic() {
        return isPublic;
    }

    @JsonProperty("isPublic")
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
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
        return new HashCodeBuilder().append(note).append(isPublic).append(timeStamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Note) == false) {
            return false;
        }
        Note rhs = ((Note) other);
        return new EqualsBuilder().append(note, rhs.note).append(isPublic, rhs.isPublic).append(timeStamp, rhs.timeStamp).isEquals();
    }

}
