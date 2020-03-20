package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ContactEmail"
})
public class Emails {

    public Emails() {
    }

    public Emails(String emails) {
        // do nothing
    }

    @JsonProperty("ContactEmail")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ContactEmail> contactEmail;

    @JsonProperty("ContactEmail")
    public List<ContactEmail> getContactEmail() {
        return contactEmail;
    }

    @JsonProperty("ContactEmail")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setContactEmail(List<ContactEmail> contactEmail) {
        this.contactEmail = contactEmail;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contactEmail).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Emails) == false) {
            return false;
        }
        Emails rhs = ((Emails) other);
        return new EqualsBuilder().append(contactEmail, rhs.contactEmail).isEquals();
    }

}
