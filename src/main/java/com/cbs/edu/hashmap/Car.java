package com.cbs.edu.hashmap;

public class Car /*implements Comparable<collections.Car>*/{

    private String model;

    private double volume;

    private String color;

    private int serial;

    public Car(String model, double volume, String color, int serial) {
        this.model = model;
        this.volume = volume;
        this.color = color;
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.volume, volume) != 0) return false;
        if (serial != car.serial) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return color != null ? color.equals(car.color) : car.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        temp = Double.doubleToLongBits(volume);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + serial;
        return result;
    }
}
