package com.ashik.kelaniya.uni.notification.impl;

import com.ashik.kelaniya.uni.notification.api.Notification;

import java.util.HashMap;
import java.util.Map;
public class InMemoryNotificationRepository implements NotificationRepository{
    Map<String, Notification> userMap=new HashMap<>();

    public InMemoryNotificationRepository(){
       /* Notification notification1 = new Notification();
        notification1.setId("1");
        notification1.setName("Temperature");
        notification1.setMessage("Please check");

        userMap.put("1",notification1);*/
    }

    @Override
    public Notification getNotification(String id) {
        if(userMap.containsKey(id)){
            return userMap.get(id);
        }
        return null;
    }

    public void notifyUser(String type){
        System.out.println("Send Notification to the User via "+type);
    }
}
