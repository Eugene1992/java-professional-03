package com.cbs.edu.patterns.decorator;

public class QuoteDecorator implements Writable {

    private Writable writable;

    public QuoteDecorator(Writable writable) {
        this.writable = writable;
    }

    @Override
    public void write(String str) {
        System.out.print("\"");
        writable.write(str);
        System.out.print("\"");
    }
}
