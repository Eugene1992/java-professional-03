package com.cbs.edu.patterns.decorator;

public class Test {
    public static void main(String[] args) {
        WritableImpl writable = new WritableImpl();
        writable.write("Hello world!");
        QuoteDecorator quoteDecorator = new QuoteDecorator(writable);
        quoteDecorator.write("Hello world!");
    }
}
