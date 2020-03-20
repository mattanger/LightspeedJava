package com.mattanger.api.model;

import com.google.api.client.util.GenericData;
import com.mattanger.api.ApiQueryValue;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class ApiGetRequest {
    private int accountId;
    private ApiQueryValue limit;
    private ApiQueryValue offset;
    private ApiQueryValue archived;
    private ApiQueryValue loadRelations;
    private ApiQueryValue timeStamp;
    private ApiQueryValue orderBy;
    private ApiQueryValue orderByDesc;
    Map<String, ApiQueryValue> queryPrams;

    public abstract static class Builder<T extends ApiGetRequest> {
        private int accountId;
        private ApiQueryValue limit;
        private ApiQueryValue offset;
        private ApiQueryValue archived;
        private ApiQueryValue loadRelations;
        private ApiQueryValue timeStamp;
        private ApiQueryValue orderBy;
        private ApiQueryValue orderByDesc;
        private Map<String, ApiQueryValue> queryParams = new HashMap<>();

        public Builder<T> withAccountId(int accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder<T> withLimit(int limit) {
            this.limit = new ApiQueryValue(Integer.toString(limit));
            this.queryParams.put("limit", this.limit);
            return this;
        }

        public Builder<T> withOffset(int offset) {
            this.offset = new ApiQueryValue(Integer.toString(offset));
            this.queryParams.put("offset", this.offset);
            return this;
        }

        public Builder<T> withArchived(boolean archived) {
            this.archived = new ApiQueryValue(Boolean.toString(archived));
            this.queryParams.put("archived", this.archived);
            return this;
        }

        public Builder<T> withLoadRelations(String loadRelations) {
            this.loadRelations = new ApiQueryValue(loadRelations);
            this.queryParams.put("load_relations", this.loadRelations);
            return this;
        }

        public Builder<T> withTimeStamp(String timeStamp, String operator) {
            this.timeStamp = new ApiQueryValue(timeStamp, operator);
            this.queryParams.put("timeStamp", this.timeStamp);
            return this;
        }

        public Builder<T> withOrderBy(String orderBy) {
            this.orderBy = new ApiQueryValue(orderBy);
            this.queryParams.put("orderby", this.orderBy);
            return this;
        }

        public Builder<T> withOrderByDesc(String orderByDesc) {
            this.orderByDesc = new ApiQueryValue(orderByDesc);
            this.queryParams.put("orderby_desc", this.orderByDesc);
            return this;
        }

        public Builder<T> withExtraParam(String paramName, String operator, String value) {
            this.queryParams.put(paramName, new ApiQueryValue(value, operator));
            return this;
        }

        public abstract T build();
    }

    /**
     * TODO: fix property ordering
     * NOTE: In this current state.. when extending this builder one
     * must remember that methods must be called from youngest to oldest
     * Child.builder().setChildParam().setParentParam().build()
     * @param builder
     */
    protected ApiGetRequest(Builder<?> builder) {
        this.limit = builder.limit;
        this.offset = builder.offset;
        this.archived = builder.archived;
        this.loadRelations = builder.loadRelations;
        this.timeStamp = builder.timeStamp;
        this.orderBy = builder.orderBy;
        this.orderByDesc = builder.orderByDesc;
        this.queryPrams = builder.queryParams;
        this.accountId = builder.accountId;
    }

    /**
     *
     * @return
     */
    public static Builder<?> builder() {
        return new Builder<ApiGetRequest>() {
            @Override
            public ApiGetRequest build() {
                return new ApiGetRequest(this);
            }
        };
    }

    public GenericData buildQueryParams() {
        GenericData params = new GenericData();
        for (Map.Entry<String, ApiQueryValue> entry : this.queryPrams.entrySet()) {
            params.put(entry.getKey(), entry.getValue().getSearch());
        }
        return params;
    }

    public int getAccountId () {
        return this.accountId;
    }

    public ApiQueryValue getLimit() {
        return limit;
    }

    public ApiQueryValue getOffset() {
        return offset;
    }

    public ApiQueryValue isArchived() {
        return archived;
    }

    public ApiQueryValue getLoadRelations() {
        return loadRelations;
    }

    public ApiQueryValue getTimeStamp() {
        return timeStamp;
    }

    public ApiQueryValue getOrderBy() {
        return orderBy;
    }

    public ApiQueryValue getOrderByDesc() {
        return orderByDesc;
    }

    public Map<String, ApiQueryValue> getQueryPrams() {
        return this.queryPrams;
    }
}
