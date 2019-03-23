package com.kelaniya.uni.product.impl;

import akka.Done;
import akka.NotUsed;
import com.google.inject.Inject;
import com.kelaniya.uni.product.api.Product;
import com.kelaniya.uni.product.api.ProductService;
import com.lightbend.lagom.javadsl.api.ServiceCall;


import java.util.concurrent.CompletableFuture;

public class ProductIpml implements ProductService {

    //this field has been injected by goole guice framework
    private final ProductRepositery productRepositery;

    @Inject

    public ProductIpml(ProductRepositery productRepositery){
        this.productRepositery = productRepositery;
    }


    @Override
    public ServiceCall<NotUsed, Product> getProductByID(String id) {


//        ProductRepositery productRepositery=new inmemeoryProductRepositery();


//        System.out.println("get product id"+id); 1 programme
        return requst ->CompletableFuture.completedFuture(productRepositery.getProduct(id));
    }

    @Override
    public ServiceCall<Product, Done> addProduct() {


        return requst -> {

            productRepositery.save(requst);//requst contaion producr object

//            System.out.println(requst.getId());
//            System.out.println(requst.getDescription());
//            System.out.println(requst.getUnitPrice());
            //save the product in database

         return   CompletableFuture.completedFuture(Done.getInstance());

        };
    }
}
