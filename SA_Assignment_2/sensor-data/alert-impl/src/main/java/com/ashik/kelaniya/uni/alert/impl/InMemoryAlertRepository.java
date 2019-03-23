package com.ashik.kelaniya.uni.alert.impl;

import com.ashik.kelaniya.uni.alert.api.Alert;

import java.util.HashMap;
import java.util.Map;
public class InMemoryAlertRepository implements AlertRepository{
    Map<String, Alert> sensorMap=new HashMap<>();

    public InMemoryAlertRepository(){
        /*Alert alert1 = new Alert();
        alert1.setSensorId("1");
        alert1.setDate("Temperature");
        alert1.setValue(35);
        Test*/

        Alert tempData = new Alert();
        String id = tempData.getSensorId();
        String date = tempData.getDate();
        double value = tempData.getValue();

        tempData.setSensorId(id);
        tempData.setDate(date);
        tempData.setValue(value);

        sensorMap.put(id,tempData);
    }
    @Override
    public Alert getSensorData(String id) {
        if(sensorMap.containsKey(id)){
            return sensorMap.get(id);
        }
        return null;
    }

    @Override
    public void save(Alert alert) {
        sensorMap.put(alert.getSensorId(),alert);
    }

    @Override
    public String trigger(String alertMessage) {
        return alertMessage;
    }
}
