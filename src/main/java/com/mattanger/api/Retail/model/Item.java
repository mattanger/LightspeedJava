package com.mattanger.api.Retail.model;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "itemID",
    "systemSku",
    "defaultCost",
    "avgCost",
    "discountable",
    "tax",
    "archived",
    "itemType",
    "serialized",
    "description",
    "modelYear",
    "upc",
    "ean",
    "customSku",
    "manufacturerSku",
    "createTime",
    "timeStamp",
    "publishToEcom",
    "categoryID",
    "taxClassID",
    "departmentID",
    "itemMatrixID",
    "manufacturerID",
    "seasonID",
    "defaultVendorID",
    "ItemComponents",
    "Category",
    "TaxClass",
    "ItemAttributes",
    "Manufacturer",
    "Note",
    "ItemShops",
    "Prices",
    "Tags"
})
public class Item {

    @JsonProperty("itemID")
    private String itemID;
    @JsonProperty("systemSku")
    private String systemSku;
    @JsonProperty("defaultCost")
    private String defaultCost;
    @JsonProperty("avgCost")
    private String avgCost;
    @JsonProperty("discountable")
    private String discountable;
    @JsonProperty("tax")
    private String tax;
    @JsonProperty("archived")
    private String archived;
    @JsonProperty("itemType")
    private String itemType;
    @JsonProperty("serialized")
    private String serialized;
    @JsonProperty("description")
    private String description;
    @JsonProperty("modelYear")
    private String modelYear;
    @JsonProperty("upc")
    private String upc;
    @JsonProperty("ean")
    private String ean;
    @JsonProperty("customSku")
    private String customSku;
    @JsonProperty("manufacturerSku")
    private String manufacturerSku;
    @JsonProperty("createTime")
    private String createTime;
    @JsonProperty("timeStamp")
    private String timeStamp;
    @JsonProperty("publishToEcom")
    private String publishToEcom;
    @JsonProperty("categoryID")
    private String categoryID;
    @JsonProperty("taxClassID")
    private String taxClassID;
    @JsonProperty("departmentID")
    private String departmentID;
    @JsonProperty("itemMatrixID")
    private String itemMatrixID;
    @JsonProperty("manufacturerID")
    private String manufacturerID;
    @JsonProperty("seasonID")
    private String seasonID;
    @JsonProperty("defaultVendorID")
    private String defaultVendorID;
    @JsonProperty("ItemComponents")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<ItemComponent> itemComponents;
    @JsonProperty("Category")
    private Category category;
    @JsonProperty("TaxClass")
    private TaxClass taxClass;
    @JsonProperty("ItemAttributes")
    private ItemAttributes itemAttributes;
    @JsonProperty("Manufacturer")
    private Manufacturer manufacturer;
    @JsonProperty("Note")
    private Note note;
    @JsonProperty("ItemShops")
    private ItemShops itemShops;
    @JsonProperty("Prices")
    private Prices prices;
    @JsonProperty("Tags")
    private Tags tags;

    @JsonProperty("itemID")
    public String getItemID() {
        return itemID;
    }

    @JsonProperty("itemID")
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    @JsonProperty("systemSku")
    public String getSystemSku() {
        return systemSku;
    }

    @JsonProperty("systemSku")
    public void setSystemSku(String systemSku) {
        this.systemSku = systemSku;
    }

    @JsonProperty("defaultCost")
    public String getDefaultCost() {
        return defaultCost;
    }

    @JsonProperty("defaultCost")
    public void setDefaultCost(String defaultCost) {
        this.defaultCost = defaultCost;
    }

    @JsonProperty("avgCost")
    public String getAvgCost() {
        return avgCost;
    }

    @JsonProperty("avgCost")
    public void setAvgCost(String avgCost) {
        this.avgCost = avgCost;
    }

    @JsonProperty("discountable")
    public String getDiscountable() {
        return discountable;
    }

    @JsonProperty("discountable")
    public void setDiscountable(String discountable) {
        this.discountable = discountable;
    }

    @JsonProperty("tax")
    public String getTax() {
        return tax;
    }

    @JsonProperty("tax")
    public void setTax(String tax) {
        this.tax = tax;
    }

    @JsonProperty("archived")
    public String getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(String archived) {
        this.archived = archived;
    }

    @JsonProperty("itemType")
    public String getItemType() {
        return itemType;
    }

    @JsonProperty("itemType")
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    @JsonProperty("serialized")
    public String getSerialized() {
        return serialized;
    }

    @JsonProperty("serialized")
    public void setSerialized(String serialized) {
        this.serialized = serialized;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("modelYear")
    public String getModelYear() {
        return modelYear;
    }

    @JsonProperty("modelYear")
    public void setModelYear(String modelYear) {
        this.modelYear = modelYear;
    }

    @JsonProperty("upc")
    public String getUpc() {
        return upc;
    }

    @JsonProperty("upc")
    public void setUpc(String upc) {
        this.upc = upc;
    }

    @JsonProperty("ean")
    public String getEan() {
        return ean;
    }

    @JsonProperty("ean")
    public void setEan(String ean) {
        this.ean = ean;
    }

    @JsonProperty("customSku")
    public String getCustomSku() {
        return customSku;
    }

    @JsonProperty("customSku")
    public void setCustomSku(String customSku) {
        this.customSku = customSku;
    }

    @JsonProperty("manufacturerSku")
    public String getManufacturerSku() {
        return manufacturerSku;
    }

    @JsonProperty("manufacturerSku")
    public void setManufacturerSku(String manufacturerSku) {
        this.manufacturerSku = manufacturerSku;
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

    @JsonProperty("publishToEcom")
    public String getPublishToEcom() {
        return publishToEcom;
    }

    @JsonProperty("publishToEcom")
    public void setPublishToEcom(String publishToEcom) {
        this.publishToEcom = publishToEcom;
    }

    @JsonProperty("categoryID")
    public String getCategoryID() {
        return categoryID;
    }

    @JsonProperty("categoryID")
    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @JsonProperty("taxClassID")
    public String getTaxClassID() {
        return taxClassID;
    }

    @JsonProperty("taxClassID")
    public void setTaxClassID(String taxClassID) {
        this.taxClassID = taxClassID;
    }

    @JsonProperty("departmentID")
    public String getDepartmentID() {
        return departmentID;
    }

    @JsonProperty("departmentID")
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    @JsonProperty("itemMatrixID")
    public String getItemMatrixID() {
        return itemMatrixID;
    }

    @JsonProperty("itemMatrixID")
    public void setItemMatrixID(String itemMatrixID) {
        this.itemMatrixID = itemMatrixID;
    }

    @JsonProperty("manufacturerID")
    public String getManufacturerID() {
        return manufacturerID;
    }

    @JsonProperty("manufacturerID")
    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    @JsonProperty("seasonID")
    public String getSeasonID() {
        return seasonID;
    }

    @JsonProperty("seasonID")
    public void setSeasonID(String seasonID) {
        this.seasonID = seasonID;
    }

    @JsonProperty("defaultVendorID")
    public String getDefaultVendorID() {
        return defaultVendorID;
    }

    @JsonProperty("defaultVendorID")
    public void setDefaultVendorID(String defaultVendorID) {
        this.defaultVendorID = defaultVendorID;
    }
    
    @JsonProperty("ItemComponents")
    public List<ItemComponent> getItemComponents() {
        return itemComponents;
    }

    @JsonProperty("ItemComponents")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    public void setItemComponents(List<ItemComponent> itemComponents) {
        this.itemComponents = itemComponents;
    }

    @JsonProperty("Category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("TaxClass")
    public TaxClass getTaxClass() {
        return taxClass;
    }

    @JsonProperty("TaxClass")
    public void setTaxClass(TaxClass taxClass) {
        this.taxClass = taxClass;
    }

    @JsonProperty("ItemAttributes")
    public ItemAttributes getItemAttributes() {
        return itemAttributes;
    }

    @JsonProperty("ItemAttributes")
    public void setItemAttributes(ItemAttributes itemAttributes) {
        this.itemAttributes = itemAttributes;
    }

    @JsonProperty("Manufacturer")
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    @JsonProperty("Manufacturer")
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @JsonProperty("Note")
    public Note getNote() {
        return note;
    }

    @JsonProperty("Note")
    public void setNote(Note note) {
        this.note = note;
    }

    @JsonProperty("ItemShops")
    public ItemShops getItemShops() {
        return itemShops;
    }

    @JsonProperty("ItemShops")
    public void setItemShops(ItemShops itemShops) {
        this.itemShops = itemShops;
    }

    @JsonProperty("Prices")
    public Prices getPrices() {
        return prices;
    }

    @JsonProperty("Prices")
    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    @JsonProperty("Tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("Tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toStringExclude(this, new String[] {""});
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(itemID).append(systemSku).append(defaultCost).append(avgCost).append(discountable).append(tax).append(archived).append(itemType).append(serialized).append(description).append(modelYear).append(upc).append(ean).append(customSku).append(manufacturerSku).append(createTime).append(timeStamp).append(publishToEcom).append(categoryID).append(taxClassID).append(departmentID).append(itemMatrixID).append(manufacturerID).append(seasonID).append(defaultVendorID).append(category).append(taxClass).append(itemAttributes).append(manufacturer).append(note).append(itemShops).append(prices).append(tags).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Item) == false) {
            return false;
        }
        Item rhs = ((Item) other);
        return new EqualsBuilder().append(itemID, rhs.itemID).append(systemSku, rhs.systemSku).append(defaultCost, rhs.defaultCost).append(avgCost, rhs.avgCost).append(discountable, rhs.discountable).append(tax, rhs.tax).append(archived, rhs.archived).append(itemType, rhs.itemType).append(serialized, rhs.serialized).append(description, rhs.description).append(modelYear, rhs.modelYear).append(upc, rhs.upc).append(ean, rhs.ean).append(customSku, rhs.customSku).append(manufacturerSku, rhs.manufacturerSku).append(createTime, rhs.createTime).append(timeStamp, rhs.timeStamp).append(publishToEcom, rhs.publishToEcom).append(categoryID, rhs.categoryID).append(taxClassID, rhs.taxClassID).append(departmentID, rhs.departmentID).append(itemMatrixID, rhs.itemMatrixID).append(manufacturerID, rhs.manufacturerID).append(seasonID, rhs.seasonID).append(defaultVendorID, rhs.defaultVendorID).append(category, rhs.category).append(taxClass, rhs.taxClass).append(itemAttributes, rhs.itemAttributes).append(manufacturer, rhs.manufacturer).append(note, rhs.note).append(itemShops, rhs.itemShops).append(prices, rhs.prices).append(tags, rhs.tags).isEquals();
    }

}
