package com.cbs.edu;

public class Car /*implements Comparable<com.cbs.edu.Car>*/{

    private String model;

    private int voulme;

    public Car(String model, int voulme) {
        this.model = model;
        this.voulme = voulme;
    }

    public String getModel() {
        return model;
    }

    public int getVoulme() {
        return voulme;
    }

    /*@Override
    public int compareTo(com.cbs.edu.Car car) {
        return this.voulme - car.voulme;
    }*/

    @Override
    public String toString() {
        return "com.cbs.edu.Car{" +
                "model='" + model + '\'' +
                ", voulme=" + voulme +
                '}';
    }
}
