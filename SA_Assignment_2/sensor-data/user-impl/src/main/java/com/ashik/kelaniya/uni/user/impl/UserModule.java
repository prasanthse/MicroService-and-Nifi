package com.ashik.kelaniya.uni.user.impl;

import com.ashik.kelaniya.uni.user.api.UserService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class UserModule extends AbstractModule implements ServiceGuiceSupport{
    @Override
    protected void configure() {

        bindService(UserService.class,UserImpl.class);
    }
}
