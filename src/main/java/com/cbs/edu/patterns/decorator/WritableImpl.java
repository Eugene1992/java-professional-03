package com.cbs.edu.patterns.decorator;

public class WritableImpl implements Writable {

    @Override
    public void write(String str) {
        System.out.println(str);
    }
}
