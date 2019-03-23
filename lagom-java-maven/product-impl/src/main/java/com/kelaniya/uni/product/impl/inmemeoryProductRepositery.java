package com.kelaniya.uni.product.impl;

import com.kelaniya.uni.product.api.Product;

import java.util.HashMap;
import java.util.Map;

public class inmemeoryProductRepositery implements ProductRepositery {


    Map<String,Product> productMap =new HashMap<>();


    public inmemeoryProductRepositery() {


        Product product1=new Product();
        product1.setDescription("Nokia Mobile Phone");
        product1.setId("111");
        product1.setUnitPrice(1000);

        Product product2=new Product();
        product2.setDescription("Water Bottle");
        product2.setId("222");
        product2.setUnitPrice(100);


        productMap.put("111",product1);
        productMap.put("222",product2);
    }



    @Override
    public Product getProduct(String id) {

        if(productMap.containsKey(id)){


            return  productMap.get(id);
        }
        return null;
    }

    @Override
    public void save(Product product) {


        productMap.put(product.getId(),product);

    }
}



