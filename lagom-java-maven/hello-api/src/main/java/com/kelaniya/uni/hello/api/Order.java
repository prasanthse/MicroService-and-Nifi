package com.kelaniya.uni.hello.api;

import java.util.List;

public class Order {


    private List<String> productIds;
    private  String userId;

    public List getProductIds() {
        return productIds;
    }

    public void setProductIds(List productIds) {
        this.productIds = productIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
