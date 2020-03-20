package com.mattanger.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ApiQueryValue {
    private String operator;
    private String value;

    public ApiQueryValue(String value, String operator) {
        // remove the leading comma if needed
        this.operator = operator == null ? "" : operator.replaceAll(",", "");
        this.value = value;
    }

    public ApiQueryValue(String value) {
        this.operator = "";
        this.value = value;
    }

    public String getSearch() {
        return (this.operator.equals("") ? "" : urlEncode("," + this.operator) ) + this.value;
    }

    public String getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    private String urlEncode(String val) {
        try {
            return URLEncoder.encode(val, "UTF-8");
        } catch (UnsupportedEncodingException uee) {}
        return URLEncoder.encode(val);
    }
}
