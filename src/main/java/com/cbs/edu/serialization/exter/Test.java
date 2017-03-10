package com.cbs.edu.serialization.exter;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        Engine engine = new Engine("v8");
        String filePath = "src\\main\\java\\com\\cbs\\edu\\serialization\\test";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(filePath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(engine);
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

            Engine desEngine = (Engine) oin.readObject();
            System.out.println(desEngine);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
