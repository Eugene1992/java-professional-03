package com.cbs.edu.serialization.exter;

import java.io.*;

public class Engine implements Externalizable {

    private String model;

    public Engine() {
    }

    public Engine(String model) {
        this.model = model;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        model = model.toUpperCase();
        out.writeObject(model);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        model = (String) in.readObject();
    }

    @Override
    public String toString() {
        return "Engine{" +
                "model='" + model + '\'' +
                '}';
    }
}
