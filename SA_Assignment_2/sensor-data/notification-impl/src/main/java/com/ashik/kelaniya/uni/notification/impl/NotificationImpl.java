package com.ashik.kelaniya.uni.notification.impl;

import akka.Done;
import akka.NotUsed;
import com.ashik.kelaniya.uni.notification.api.Notification;
import com.ashik.kelaniya.uni.notification.api.NotificationService;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public class NotificationImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Inject
    public NotificationImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public ServiceCall<Notification, Done> sendNotification(String type){
        //System.out.println("get product by id method is called with id "+ id);

        //  ProductRepository productRepository=new InMemoryUserRepository();

        switch (type){
                case "Email":
                    System.out.println("Notify user with email");
                    break;

                case "SMS":
                    System.out.println("Notify user with SMS");
                    break;

                case "Phone": {
                    System.out.println("Notify user with Phone Call");
                    break;
            }
        }
        return request -> CompletableFuture.completedFuture(null);
    }
}
