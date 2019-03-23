package com.ashik.kelaniya.uni.alert.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import static com.lightbend.lagom.javadsl.api.Service.named;

public interface AlertService extends Service{
    ServiceCall<NotUsed,Alert> getSensorById(String id);
    ServiceCall<Alert, Done> addSensorData();
    Boolean triggerSensorData(Alert alert);

    @Override
    default Descriptor descriptor() {
        return named("alert").withCalls(
                pathCall("/api/sensor/:id",  this::getSensorById),
                pathCall("/api/sensor/add",  this::addSensorData)
        ).withAutoAcl(true);
    }
}
