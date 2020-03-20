package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firstName",
    "lastName",
    "dob",
    "title",
    "company",
    "companyRegistrationNumber",
    "vatNumber",
    "creditAccountID",
    "customerTypeID",
    "discountID",
    "taxCategoryID",
    "Contact",
    "CustomerType",
    "Note",
    "TaxCategory",
    "customerID",
    "createTime",
    "timeStamp",
    "archived",
    "CreditAccount",
//    "Tags"
})
@JsonIgnoreProperties(value = { "Tags" })
public class Customer {

    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("title")
    private String title;
    @JsonProperty("company")
    private String company;
    @JsonProperty("companyRegistrationNumber")
    private String companyRegistrationNumber;
    @JsonProperty("vatNumber")
    private String vatNumber;
    @JsonProperty("creditAccountID")
    private String creditAccountID;
    @JsonProperty("customerTypeID")
    private String customerTypeID;
    @JsonProperty("discountID")
    private String discountID;
    @JsonProperty("taxCategoryID")
    private String taxCategoryID;
    @JsonProperty("Contact")
    private Contact contact;
    @JsonProperty("CustomerType")
    private CustomerType customerType;
    @JsonProperty("Note")
    private Note note;
    @JsonProperty("TaxCategory")
    private TaxCategory taxCategory;
    @JsonProperty("customerID")
    private String customerID;
    @JsonProperty("createTime")
    private String createTime;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("archived")
    private String archived;
    @JsonProperty("CreditAccount")
    private CreditAccount creditAccount;
//    @JsonProperty("Tags")
    private Tags tags;

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("dob")
    public String getDob() {
        return dob;
    }

    @JsonProperty("dob")
    public void setDob(String dob) {
        this.dob = dob;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("company")
    public String getCompany() {
        return company;
    }

    @JsonProperty("company")
    public void setCompany(String company) {
        this.company = company;
    }

    @JsonProperty("companyRegistrationNumber")
    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    @JsonProperty("companyRegistrationNumber")
    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    @JsonProperty("vatNumber")
    public String getVatNumber() {
        return vatNumber;
    }

    @JsonProperty("vatNumber")
    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @JsonProperty("creditAccountID")
    public String getCreditAccountID() {
        return creditAccountID;
    }

    @JsonProperty("creditAccountID")
    public void setCreditAccountID(String creditAccountID) {
        this.creditAccountID = creditAccountID;
    }

    @JsonProperty("customerTypeID")
    public String getCustomerTypeID() {
        return customerTypeID;
    }

    @JsonProperty("customerTypeID")
    public void setCustomerTypeID(String customerTypeID) {
        this.customerTypeID = customerTypeID;
    }

    @JsonProperty("discountID")
    public String getDiscountID() {
        return discountID;
    }

    @JsonProperty("discountID")
    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    @JsonProperty("taxCategoryID")
    public String getTaxCategoryID() {
        return taxCategoryID;
    }

    @JsonProperty("taxCategoryID")
    public void setTaxCategoryID(String taxCategoryID) {
        this.taxCategoryID = taxCategoryID;
    }

    @JsonProperty("Contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("Contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @JsonProperty("CustomerType")
    public CustomerType getCustomerType() {
        return customerType;
    }

    @JsonProperty("CustomerType")
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @JsonProperty("Note")
    public Note getNote() {
        return note;
    }

    @JsonProperty("Note")
    public void setNote(Note note) {
        this.note = note;
    }

    @JsonProperty("TaxCategory")
    public TaxCategory getTaxCategory() {
        return taxCategory;
    }

    @JsonProperty("TaxCategory")
    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }

    @JsonProperty("customerID")
    public String getCustomerID() {
        return customerID;
    }

    @JsonProperty("customerID")
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
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

    @JsonProperty("archived")
    public String getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(String archived) {
        this.archived = archived;
    }

    @JsonProperty("CreditAccount")
    public CreditAccount getCreditAccount() {
        return creditAccount;
    }

    @JsonProperty("CreditAccount")
    public void setCreditAccount(CreditAccount creditAccount) {
        this.creditAccount = creditAccount;
    }

//    @JsonProperty("Tags")
    public Tags getTags() {
        return tags;
    }

//    @JsonProperty("Tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(firstName).append(lastName).append(dob).append(title).append(company).append(companyRegistrationNumber).append(vatNumber).append(creditAccountID).append(customerTypeID).append(discountID).append(taxCategoryID).append(contact).append(customerType).append(note).append(taxCategory).append(customerID).append(createTime).append(timeStamp).append(archived).append(creditAccount).append(tags).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customer) == false) {
            return false;
        }
        Customer rhs = ((Customer) other);
        return new EqualsBuilder().append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(dob, rhs.dob).append(title, rhs.title).append(company, rhs.company).append(companyRegistrationNumber, rhs.companyRegistrationNumber).append(vatNumber, rhs.vatNumber).append(creditAccountID, rhs.creditAccountID).append(customerTypeID, rhs.customerTypeID).append(discountID, rhs.discountID).append(taxCategoryID, rhs.taxCategoryID).append(contact, rhs.contact).append(customerType, rhs.customerType).append(note, rhs.note).append(taxCategory, rhs.taxCategory).append(customerID, rhs.customerID).append(createTime, rhs.createTime).append(timeStamp, rhs.timeStamp).append(archived, rhs.archived).append(creditAccount, rhs.creditAccount).append(tags, rhs.tags).isEquals();
    }

}
