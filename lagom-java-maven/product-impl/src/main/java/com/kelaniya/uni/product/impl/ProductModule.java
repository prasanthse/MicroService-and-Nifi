package com.kelaniya.uni.product.impl;

import com.google.inject.AbstractModule;
import com.kelaniya.uni.product.api.ProductService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class ProductModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    bindService(ProductService.class, ProductIpml.class);
  }
}
