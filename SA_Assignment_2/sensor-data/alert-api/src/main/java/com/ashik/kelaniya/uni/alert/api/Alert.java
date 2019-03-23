package com.ashik.kelaniya.uni.alert.api;

public class Alert {
    private String sensorId;
    private String date;
    private double value;

    public Alert() {
    }

    public Alert(String sensorId, String date, double value) {
        this.sensorId = sensorId;
        this.date = date;
        this.value = value;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
