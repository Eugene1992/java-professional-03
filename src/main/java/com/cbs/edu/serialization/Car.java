package com.cbs.edu.serialization;

import java.io.Serializable;

public class Car implements Serializable {

    private transient String model;
    private Engine engine;
    private int volume;

    public Car(String model, int volume, Engine engine) {
        this.model = model;
        this.volume = volume;
        this.engine = engine;
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
