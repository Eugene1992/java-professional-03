package com.cbs.edu.serialization.gson;

import com.google.gson.annotations.SerializedName;

public class Car {

    private String model;

    @SerializedName("vol")
    private int volume;

    public Car(String model, int volume) {
        this.model = model;
        this.volume = volume;
    }

    public String getModel() {
        return model;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "com.cbs.edu.Car{" +
                "model='" + model + '\'' +
                ", volume=" + volume +
                '}';
    }
}
