package com.mattanger.driver;

import com.google.api.client.http.HttpRequestFactory;
import com.mattanger.LightspeedAuth;
import com.mattanger.api.Retail.*;
import com.mattanger.api.Retail.model.*;
import com.mattanger.api.Retail.request.*;
import com.mattanger.api.Retail.response.*;
import com.mattanger.api.model.ApiGetRequest;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

public class ExportToCsvDriver {
    static final int accountId = 109232;

    private static String ITEMS_FILE = "/tmp/items.csv";
    private static String INVENTORY_FILE = "/tmp/inventory.csv";
    private static String PRICES = "/tmp/item-prices.csv";
    private static String ITEM_CATEGORY = "/tmp/item-categories.csv";
    private static String CUSTOMERS = "/tmp/customer.csv";
    private static String MANUFACTURER = "/tmp/manufacturer.csv";
    private static String VENDOR = "/tmp/vendor.csv";
    private static String TAX_CAT = "/tmp/tax-categories.csv";
    private static String DISCOUNTS = "/tmp/discounts.csv";

    private static CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator(System.lineSeparator());

    private static HttpRequestFactory requestFactory;


    public static void main(String[] args) {
        try {
            requestFactory = LightspeedAuth.httpRequestFactory("9a91a388410068395ac33e4bc1abc198c66bf9a8");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
//        buildItemCategoryCsv();
        // build the item CSVs
//        writeItemCsv();

//        buildManufacturererCsv();

//        buildVendorCsv();
//        buildCustomerCsv();

//        buildTaxCategories();
        buildDiscounts();
    }

    // todo break up and make more functional
    private static void writeItemCsv() {

        Map<String, List<ItemPrice>> priceMap = new HashMap<>();
        List<ItemShop> shops = new LinkedList<>();

        try ( FileWriter fw = new FileWriter(ITEMS_FILE);
              CSVPrinter itemCsvPrinter = new CSVPrinter(fw, csvFormat);)  {

            ItemApi itemApi = new ItemApi(requestFactory);
            GetItemResponse response = itemApi.getItem(GetItemRequest.builder()
                    .withLoadRelations("[\"ItemShops\"]")
                    .withAccountId(accountId)
                    .build());

            Field[] fields = response.Item.get(0).getClass().getDeclaredFields();
            List<String> headers = Arrays.asList(fields).stream()
                    .map(Field::getName)
                    .collect(Collectors.toList());
            itemCsvPrinter.printRecord(headers);

            for (Item i: response.Item) {
                List<String> row = new ArrayList<>(headers.size());
                for (String col : headers) {
                    Field f = i.getClass().getDeclaredField(col);
                    String value;
                    f.setAccessible(true);
                    Object o = f.get(i);
                    if (col.equals("itemShops")) {
                        value = "";
                        shops.addAll(i.getItemShops().getItemShop());
                    } else if (col.equals("prices")) {
                        value = "";
                        priceMap.put(i.getItemID(), i.getPrices().getItemPrice());
                    } else {
                        if (o == null) value = "";
                        else value = o instanceof String ? (String) o : "";
                    }
                    row.add(value);

                }
                itemCsvPrinter.printRecord(row);
            }
            buildItemPriceCsv(priceMap);
            buildItemShopCsv(shops);
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

    }

    private static void buildItemPriceCsv(Map<String, List<ItemPrice>> priceMap) {
        try ( FileWriter fw = new FileWriter(PRICES);
              CSVPrinter printer = new CSVPrinter(fw, csvFormat)) {
            printer.printRecord(new String[] {"itemID", "amount", "useTypeID", "useType"});
            for(Map.Entry<String, List<ItemPrice>> entry : priceMap.entrySet()) {
                for (ItemPrice p : entry.getValue()) {
                    List<String> row = new LinkedList<>();
                    row.add(entry.getKey());
                    row.add(p.getAmount());
                    row.add(p.getUseTypeID());
                    row.add(p.getUseType());
                    printer.printRecord(row);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void buildItemShopCsv(List<ItemShop> itemShops) {

        try (FileWriter fw = new FileWriter(INVENTORY_FILE);
             CSVPrinter printer = new CSVPrinter(fw, csvFormat))  {

            printer.printRecord(new String[] {"itemShopId", "qoh", "backorder", "componentQoh", "componentBackorder", "reorderPoint", "reorderLevel", "timeStamp", "itemID", "shopID"});
            for (ItemShop shop : itemShops) {
                List<String> row = new LinkedList<>();
                row.add(shop.getItemShopID());
                row.add(shop.getQoh());
                row.add(shop.getBackorder());
                row.add(shop.getComponentQoh());
                row.add(shop.getComponentBackorder());
                row.add(shop.getReorderPoint());
                row.add(shop.getReorderLevel());
                row.add(shop.getTimeStamp());
                row.add(shop.getItemID());
                row.add(shop.getShopID());
                printer.printRecord(row);
            }
            fw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void buildItemCategoryCsv() {
        CategoryApi categoryApi = new CategoryApi(requestFactory);
        GetCategoryRequest getCategoryRequest = GetCategoryRequest
                .builder()
                .withAccountId(accountId)
                .build();

        try (FileWriter fw = new FileWriter(ITEM_CATEGORY);
             CSVPrinter printer = new CSVPrinter(fw, csvFormat)) {
            GetCategoryResponse response = categoryApi.getCategories(getCategoryRequest);
            printer.printRecord(new String[] {"categoryID", "name", "nodeDepth", "fullPathName", "leftNode", "rightNode", "createTime", "timeStamp", "parentID"});
            for (Category category : response.getCategory()) {
                List<String> row = new LinkedList<>();
                row.add(category.getCategoryID());
                row.add(category.getName());
                row.add(category.getNodeDepth());
                row.add(category.getFullPathName());
                row.add(category.getLeftNode());
                row.add(category.getRightNode());
                row.add(category.getCreateTime());
                row.add(category.getTimeStamp());
                row.add(category.getParentID());
                printer.printRecord(row);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }

    private static void buildCustomerCsv() {
        try (FileWriter fw = new FileWriter(CUSTOMERS);
            CSVPrinter printer = new CSVPrinter(fw, csvFormat))  {

            CustomerApi customerApi = new CustomerApi(requestFactory);
            GetCustomerRequest getCustomerRequest = GetCustomerRequest.builder()
                    .withAccountId(accountId)
                    .withLoadRelations("all")
                    .build();
            GetCustomerResponse response = customerApi.getCustomer(getCustomerRequest);
            String[] baseHeader = {"customerId","firstName","lastName","dob","title","company","companyRegistrationNumber",
                    "vatNumber","creditAccountId","customerTypeID","discountID","taxCategoryID","archived","address1",
                    "address2","city","state","zip","country","phoneNumber","email"
            };
            List<String> header = new LinkedList<>();
            header.addAll(Arrays.asList(baseHeader));
            List<List<String>> csvData = new LinkedList<>();
            printer.printRecord(header);
            for (Customer cust : response.getCustomer()) {
                System.out.println(cust.getCustomerID());
                List<String> row = new LinkedList<>();
                row.add(cust.getCustomerID());
                row.add(cust.getFirstName());
                row.add(cust.getLastName());
                row.add(cust.getDob());
                row.add(cust.getTitle());
                row.add(cust.getCompany());
                row.add(cust.getCompanyRegistrationNumber());
                row.add(cust.getVatNumber());
                row.add(cust.getCreditAccountID());
                row.add(cust.getCustomerTypeID());
                row.add(cust.getDiscountID());
                row.add(cust.getTaxCategoryID());
                row.add(cust.getArchived());
                addContactInfo(cust, row);
                printer.printRecord(row);
            }



        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void addContactInfo(Customer customer, List<String> row) {
        Contact contact = customer.getContact();
        int counter = 1;
        if (customer.getContact() == null) {
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            return;
        }
        if (customer.getContact().getAddresses().getContactAddress() != null) {
            ContactAddress address = customer.getContact().getAddresses().getContactAddress().get(0);
            row.add(address.getAddress1());
            row.add(address.getAddress2());
            row.add(address.getCity());
            row.add(address.getState());
            row.add(address.getZip());
            row.add(address.getCountry());
        } else {
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            row.add("");
            row.add("");
        }
       if (customer.getContact().getPhones().getContactPhone() != null) {
           ContactPhone phone = customer.getContact().getPhones().getContactPhone().get(0);
           if (phone != null) {
               row.add(phone.getNumber());
           } else {
               row.add("");
           }
       } else {
            row.add("");
       }
       if (customer.getContact().getEmails().getContactEmail() != null) {
           ContactEmail email = customer.getContact().getEmails().getContactEmail().get(0);
           if (email != null) {
               row.add(email.getAddress());
           } else {
               row.add("");
           }
       } else {
            row.add("");
       }
    }

    public static void buildTaxCategories() {
        try (FileWriter fw = new FileWriter(TAX_CAT);
             CSVPrinter printer = new CSVPrinter(fw, csvFormat)) {
            TaxCategoryApi taxApi = new TaxCategoryApi(requestFactory);
            ApiGetRequest getRequest = ApiGetRequest.builder().withAccountId(accountId).build();
            GetTaxCategoryResponse response = taxApi.getTaxCategory(getRequest);
            String[] header = {"taxCategoryID", "isTaxInclusive", "tax1Name", "tax2Name", "tax1Rate", "tax2Rate"};
            printer.printRecord(header);
            for (TaxCategory tc : response.getTaxCategory()) {
                List<String> row = new LinkedList<>();
                row.add(tc.getTaxCategoryID());
                row.add(tc.getIsTaxInclusive());
                row.add(tc.getTax1Name());
                row.add(tc.getTax2Name());
                row.add(tc.getTax1Rate());
                row.add(tc.getTax2Rate());
                printer.printRecord(row);
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void buildDiscounts() {
        try (FileWriter fw = new FileWriter(DISCOUNTS);
             CSVPrinter printer = new CSVPrinter(fw, csvFormat)) {

            DiscountApi api = new DiscountApi(requestFactory);
            ApiGetRequest request = ApiGetRequest.builder().withAccountId(accountId).build();
            GetDiscountResponse response = api.getDiscounts(request);
            String[] header = {"discountID", "name", "discountAmount", "discountPercent", "requireCustomer", "archived"};
            printer.printRecord(header);
            for(Discount d : response.getDiscounts()) {
                List<String> row = new LinkedList<>();
                row.add(Integer.toString(d.getDiscountID()));
                row.add(d.getName());
                row.add(Float.toString(d.getDiscountAmount()));
                row.add(Float.toString(d.getDiscountPercent()));
                row.add(Boolean.toString(d.isRequireCustomer()));
                row.add(Boolean.toString(d.getArchived()));
                printer.printRecord(row);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void buildManufacturererCsv() {
        try (FileWriter fw = new FileWriter(MANUFACTURER);
             CSVPrinter printer = new CSVPrinter(fw, csvFormat)){

            ManufacturerApi api = new ManufacturerApi(requestFactory);
            GetManufacturerResponse response = api.getManufacturer(GetManufacturerRequest.builder().withAccountId(accountId).build());
            printer.printRecord(new String[] {"manufacturerID", "name", "createTime", "timeStamp"});
            for(Manufacturer m : response.getManufacturer()) {
                List<String> row = new LinkedList<>();
                row.add(m.getManufacturerID());
                row.add(m.getName());
                row.add(m.getCreateTime());
                row.add(m.getTimeStamp());
                printer.printRecord(row);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void buildVendorCsv() {
        try (FileWriter fw = new FileWriter(VENDOR);
             CSVPrinter printer = new CSVPrinter(fw, csvFormat)){

            printer.printRecord(new String[] {"vendorID", "name", "accountNumber", "priceLevel", "updatePrice", "updateCost", "updateDescription", "shareSellThrough"});
            VendorApi vendorApi = new VendorApi(requestFactory);
            GetVendorResponse response = vendorApi.getVendor(GetVendorRequest.builder().withAccountId(accountId).build());
            List<Contact> contacts = new LinkedList<>();
            for(Vendor vendor : response.getVendor()) {
                List<String> row = new LinkedList<>();
                row.add(vendor.getVendorID());
                row.add(vendor.getName());
                row.add(vendor.getAccountNumber());
                row.add(vendor.getPriceLevel());
                row.add(vendor.getUpdatePrice());
                row.add(vendor.getUpdateCost());
                row.add(vendor.getUpdateDescription());
                row.add(vendor.getShareSellThrough());
                printer.printRecord(row);
                contacts.add(vendor.getContact());
            }


        } catch (IOException ioe) {
                 ioe.printStackTrace();
        }
    }

    public static void buildContactCsv(String fileName, List<Contact> contacts) {

    }
}
