package com.ashik.kelaniya.uni.notification.api;

public class Notification {
    private String notificationType;

    public Notification(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }
}
