package com.kelaniya.uni.product.impl;

import com.google.inject.ImplementedBy;
import com.kelaniya.uni.product.api.Product;


@ImplementedBy(inmemeoryProductRepositery.class)
public interface ProductRepositery {


    Product getProduct(String id);

    void save(Product product);

}
