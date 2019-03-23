package com.kelaniya.uni.product.api;
import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.topic;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.broker.Topic;
import com.lightbend.lagom.javadsl.api.broker.kafka.KafkaProperties;

public interface ProductService extends Service {



    ServiceCall<NotUsed, Product> getProductByID(String id);//either you put or not by defalt public//requst is produt
    ServiceCall<Product,Done> addProduct();     //done is response                                      //response is product





    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("product").withCalls(//identify this servisee uniquly from otjer services
                pathCall("/api/product/:id",  this::getProductByID),
                                             //path parameter. : says this is path parameter
                pathCall("/api/product",  this::addProduct)//


        ).withAutoAcl(true);
        // @formatter:on
    }
}
