package com.ashik.kelaniya.uni.alert.impl;

import akka.Done;
import akka.NotUsed;
import com.ashik.kelaniya.uni.alert.api.Alert;
import com.ashik.kelaniya.uni.alert.api.AlertService;
import com.ashik.kelaniya.uni.notification.api.Notification;
import com.ashik.kelaniya.uni.notification.api.NotificationService;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public class AlertImpl implements AlertService {
    private final AlertRepository alertRepository;

    private NotificationService notificationService;

    @Inject
    public AlertImpl(AlertRepository alertRepository, NotificationService notificationService) {
        this.alertRepository = alertRepository;
        this.notificationService = notificationService;
    }

    @Override
    public ServiceCall<NotUsed, Alert> getSensorById(String id) {
        //System.out.println("get product by id method is called with id "+ id);

        //  ProductRepository productRepository=new InMemoryUserRepository();
        return request -> CompletableFuture.completedFuture(alertRepository.getSensorData(id));
    }

    @Override
    public ServiceCall<Alert, Done> addSensorData() {
        //System.out.println("get product by id method is called with id "+ id);

        //  ProductRepository productRepository=new InMemoryUserRepository();


        return request -> {

            Notification notification = new Notification("Email");

            alertRepository.save(request);
            if(triggerSensorData(request)) {
                notificationService.sendNotification(notification.getNotificationType());
            }
//            System.out.println(requst.getId());
//            System.out.println(requst.getDescription());
//            System.out.println(requst.getUnitPrice());
            //save the product in database

            return CompletableFuture.completedFuture(Done.getInstance());

        };
    }

    @Override
    public Boolean triggerSensorData(Alert alert) {
        //System.out.println("get product by id method is called with id "+ id);

        //  ProductRepository productRepository=new InMemoryUserRepository();

        alertRepository.getSensorData(alert.getSensorId());

        String msg;
        if (alert.getValue() > 30) {
            msg = "Value is higher than treshohold";
        } else {
            msg = "Value is lower than treshohold";
        }
        // System.out.println(alertRepository.trigger(msg));
        // return request -> CompletableFuture.completedFuture(Done.done());
        return alert.getValue()>30 ;
    }
}


