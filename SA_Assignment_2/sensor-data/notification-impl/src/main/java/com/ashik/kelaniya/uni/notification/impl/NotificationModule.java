package com.ashik.kelaniya.uni.notification.impl;

import com.ashik.kelaniya.uni.notification.api.NotificationService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class NotificationModule extends AbstractModule implements ServiceGuiceSupport{
    @Override
    protected void configure() {
        bindService(NotificationService.class,NotificationImpl.class);
    }
}
