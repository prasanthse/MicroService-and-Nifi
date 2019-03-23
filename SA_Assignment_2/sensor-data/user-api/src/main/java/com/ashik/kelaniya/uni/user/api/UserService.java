package com.ashik.kelaniya.uni.user.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.named;

public interface UserService extends Service{
    ServiceCall<NotUsed,User> getUserById(String id);
    ServiceCall<User, Done> addUser();

    @Override
    default Descriptor descriptor() {
        return named("user").withCalls(
                pathCall("/api/user/:id",  this::getUserById),
                pathCall("/api/user/add",  this::addUser)
        ).withAutoAcl(true);
    }
}
