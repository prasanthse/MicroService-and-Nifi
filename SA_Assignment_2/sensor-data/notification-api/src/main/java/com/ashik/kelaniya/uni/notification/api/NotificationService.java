package com.ashik.kelaniya.uni.notification.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.named;

public interface NotificationService extends Service{
    ServiceCall<Notification,Done>  sendNotification(String type);

    @Override
    default Descriptor descriptor() {
        return named("notification").withCalls(
                pathCall("/api/notification",  this::sendNotification)
        ).withAutoAcl(true);
    }
}
