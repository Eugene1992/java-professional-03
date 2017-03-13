package com.cbs.edu.serialization.gson;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Car tesla = new Car("Tesla", 10);
        String json = gson.toJson(tesla);
        System.out.println(json);

        String data = "{\"model\":\"BMW\",\"vol\":20}";
        Car car = gson.fromJson(data, Car.class);
        System.out.println(car);
    }
}
