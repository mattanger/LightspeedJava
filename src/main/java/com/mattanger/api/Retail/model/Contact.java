package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mattanger.Deserializer;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "custom",
    "noEmail",
    "noPhone",
    "noMail",
    "Addresses",
    "Phones",
    "Emails",
    "Websites",
    "timeStamp"
})
public class Contact {

    @JsonProperty("custom")
    private String custom;
    @JsonProperty("noEmail")
    private String noEmail;
    @JsonProperty("noPhone")
    private String noPhone;
    @JsonProperty("noMail")
    private String noMail;
    @JsonProperty("Addresses")
//    @JsonDeserialize(using = Deserializer.class)
    private Addresses addresses;
    @JsonProperty("Phones")
//    @JsonDeserialize(using = Deserializer.class)
    private Phones phones;
    @JsonProperty("Emails")
//    @JsonDeserialize(using = Deserializer.class)
    private Emails emails;
    @JsonProperty("Websites")
    private String websites;
    @JsonProperty("timeStamp")
    private String timeStamp;

    @JsonProperty("custom")
    public String getCustom() {
        return custom;
    }

    @JsonProperty("custom")
    public void setCustom(String custom) {
        this.custom = custom;
    }

    @JsonProperty("noEmail")
    public String getNoEmail() {
        return noEmail;
    }

    @JsonProperty("noEmail")
    public void setNoEmail(String noEmail) {
        this.noEmail = noEmail;
    }

    @JsonProperty("noPhone")
    public String getNoPhone() {
        return noPhone;
    }

    @JsonProperty("noPhone")
    public void setNoPhone(String noPhone) {
        this.noPhone = noPhone;
    }

    @JsonProperty("noMail")
    public String getNoMail() {
        return noMail;
    }

    @JsonProperty("noMail")
    public void setNoMail(String noMail) {
        this.noMail = noMail;
    }

    @JsonProperty("Addresses")
    public Addresses getAddresses() {
        return addresses;
    }

    @JsonProperty("Addresses")
    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("Phones")
    public Phones getPhones() {
        return phones;
    }

    @JsonProperty("Phones")
    public void setPhones(Phones phones) {
        this.phones = phones;
    }

    @JsonProperty("Emails")
    public Emails getEmails() {
        return emails;
    }

    @JsonProperty("Emails")
    public void setEmails(Emails emails) {
        this.emails = emails;
    }
//    @JsonProperty("Emails") //hack?
//    public void setEmails(String emails) {}

    @JsonProperty("Websites")
    public String getWebsites() {
        return websites;
    }

    @JsonProperty("Websites")
    public void setWebsites(String websites) {
        this.websites = websites;
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
        return new HashCodeBuilder().append(custom).append(noEmail).append(noPhone).append(noMail).append(addresses).append(phones).append(emails).append(websites).append(timeStamp).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Contact) == false) {
            return false;
        }
        Contact rhs = ((Contact) other);
        return new EqualsBuilder().append(custom, rhs.custom).append(noEmail, rhs.noEmail).append(noPhone, rhs.noPhone).append(noMail, rhs.noMail).append(addresses, rhs.addresses).append(phones, rhs.phones).append(emails, rhs.emails).append(websites, rhs.websites).append(timeStamp, rhs.timeStamp).isEquals();
    }

}
