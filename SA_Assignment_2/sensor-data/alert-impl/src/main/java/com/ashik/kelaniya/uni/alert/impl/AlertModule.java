package com.ashik.kelaniya.uni.alert.impl;

import com.ashik.kelaniya.uni.alert.api.AlertService;
import com.ashik.kelaniya.uni.notification.api.NotificationService;
import com.google.inject.AbstractModule;

import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class AlertModule extends AbstractModule implements ServiceGuiceSupport{
    @Override
    protected void configure() {

        bindService(AlertService.class,AlertImpl.class);
        bindClient(NotificationService.class);
    }
}
