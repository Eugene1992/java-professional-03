package com.cbs.edu.serialization;

import com.cbs.edu.io.serializable.Main;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Car car = new Car("Tesla", 4, new Engine());
        String filePath = "src\\main\\java\\com\\cbs\\edu\\serialization\\test";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(car);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        ObjectInputStream oin = null;
        try {
            fis = new FileInputStream(filePath);
            oin = new ObjectInputStream(fis);

            Car desCar = (Car) oin.readObject();
            System.out.println(desCar);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
