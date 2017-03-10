package com.cbs.edu.reflection;

import java.lang.annotation.Native;

public class Car {


    private String model;

    @MyAnnotation(value = {"", ""})
    @Deprecated
    private int volume;

    public int number;

    public Car(String model, int volume, int number) {
        this.model = model;
        this.volume = volume;
        this.number = number;
    }

    public Car() {
    }

    public int getVolume() {
        return volume;
    }

    private void printVolume() {
        System.out.println("Volume is: " + volume);
    }
}
