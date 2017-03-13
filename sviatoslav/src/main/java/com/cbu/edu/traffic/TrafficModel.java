package com.cbu.edu.traffic;

import java.time.LocalDate;
import java.util.Formatter;

/**
 * Created by Sviatoslav on 12.03.2017.
 */
public class TrafficModel {
    private LocalDate date;
    private double uaInput;
    private double uaOutput;
    private double inetInput;
    private double inetOutput;
    private double someValue;
    private double anotherValue;

    public TrafficModel(LocalDate date, double uaInput, double uaOutput, double inetInput, double inetOutput, double someValue, double anotherValue) {
        this.date = date;
        this.uaInput = uaInput;
        this.uaOutput = uaOutput;
        this.inetInput = inetInput;
        this.inetOutput = inetOutput;
        this.someValue = someValue;
        this.anotherValue = anotherValue;
    }

    public double getSomeValue() {
        return someValue;
    }

    public void setSomeValue(double someValue) {
        this.someValue = someValue;
    }

    public double getAnotherValue() {
        return anotherValue;
    }

    public void setAnotherValue(double anotherValue) {
        this.anotherValue = anotherValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void LocalDateTime(LocalDate date) {
        this.date = date;
    }

    public double getUaInput() {
        return uaInput;
    }

    public void setUaInput(double uaInput) {
        this.uaInput = uaInput;
    }

    public double getUaOutput() {
        return uaOutput;
    }

    public void setUaOutput(double uaOutput) {
        this.uaOutput = uaOutput;
    }

    public double getInetInput() {
        return inetInput;
    }

    public void setInetInput(double inetInput) {
        this.inetInput = inetInput;
    }

    public double getInetOutput() {
        return inetOutput;
    }

    public void setInetOutput(double inetOutput) {
        this.inetOutput = inetOutput;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrafficModel that = (TrafficModel) o;

        if (Double.compare(that.uaInput, uaInput) != 0) return false;
        if (Double.compare(that.uaOutput, uaOutput) != 0) return false;
        if (Double.compare(that.inetInput, inetInput) != 0) return false;
        if (Double.compare(that.inetOutput, inetOutput) != 0) return false;
        if (Double.compare(that.someValue, someValue) != 0) return false;
        if (Double.compare(that.anotherValue, anotherValue) != 0) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = date != null ? date.hashCode() : 0;
        temp = Double.doubleToLongBits(uaInput);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(uaOutput);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(inetInput);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(inetOutput);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(someValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(anotherValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        Formatter formatter = new Formatter();
        String f = String.valueOf(formatter.format("Date = %tF , UaInput= %.3f, uaOutput= %.3f, InetInput= %.3f, InetOutput = %.3f, someValue = %.3f, anotherValue = %.3f \n",
                date, uaInput, uaOutput, inetInput, inetOutput, someValue, anotherValue));
        return f;
    }
}
