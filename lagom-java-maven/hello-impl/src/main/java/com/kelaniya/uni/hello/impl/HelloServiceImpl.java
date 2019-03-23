package com.kelaniya.uni.hello.impl;

import akka.Done;
import akka.NotUsed;
import com.google.inject.Inject;
import com.kelaniya.uni.hello.api.GreetingMessage;
import com.kelaniya.uni.hello.api.HelloEvent;
import com.kelaniya.uni.hello.api.Order;
import com.kelaniya.uni.product.api.Product;
import com.kelaniya.uni.product.api.ProductService;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.kelaniya.uni.hello.api.HelloService;
import com.lightbend.lagom.javadsl.api.broker.Topic;

/**
 * Implementation of the HelloService.
 */
public  class HelloServiceImpl implements HelloService {

  public final ProductService productService;

  @Inject

  public HelloServiceImpl(ProductService productService) {
    this.productService = productService;
  }


  @Override
  public ServiceCall<NotUsed, String> hello(String id) {
    return null;
  }

  @Override
    public ServiceCall<Order, Done> placeOrder() {


      return  request -> {

        double totalCost = 0;

        //save the odede in order repositery

        List<String>productIds=request.getProductIds();

        for (String productId:productIds){

          try {
            Product product = productService.getProductByID(productId).invoke().toCompletableFuture().get();

            totalCost+= product.getUnitPrice();//implement the taotl cose


          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (ExecutionException e) {
            e.printStackTrace();
          }

        }
        System.out.println("The total order cost is : " + totalCost);
        //cal culate total oder cost before save
        System.out.println("Saving the order to database");



        return   CompletableFuture.completedFuture(Done.getInstance());




      };

    }

  @Override
  public Topic<HelloEvent> helloEvents() {
    return null;
  }

  @Override
  public Descriptor descriptor() {
    return null;
  }


}
