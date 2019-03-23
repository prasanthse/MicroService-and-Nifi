package com.kelaniya.uni.hello.impl;

import com.google.inject.AbstractModule;
import com.kelaniya.uni.product.api.Product;
import com.kelaniya.uni.product.api.ProductService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.kelaniya.uni.hello.api.HelloService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class HelloModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    bindService(HelloService.class, HelloServiceImpl.class);//servise binding
    bindClient(ProductService.class);//client binding

  }
}
