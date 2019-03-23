package com.ashik.kelaniya.uni.notification.impl;

import com.ashik.kelaniya.uni.notification.api.Notification;
import com.google.inject.ImplementedBy;

@ImplementedBy(InMemoryNotificationRepository.class)
public interface NotificationRepository {
    Notification getNotification(String id);
    void notifyUser(String type);
}
