package com.ashik.kelaniya.uni.alert.impl;

import com.ashik.kelaniya.uni.alert.api.Alert;
import com.google.inject.ImplementedBy;

@ImplementedBy(InMemoryAlertRepository.class)
public interface AlertRepository {
    Alert getSensorData(String id);
    void save(Alert alert);
    String trigger(String alertMessage);
}
