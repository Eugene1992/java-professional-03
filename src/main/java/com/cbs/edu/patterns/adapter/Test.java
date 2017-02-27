package com.cbs.edu.patterns.adapter;

public class Test {
    public static void main(String[] args) {
        byte[] bytes = {123, 121, 21, 12, 34};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        System.out.println(byteArrayInputStream.read());
        System.out.println(byteArrayInputStream.read());
        System.out.println(byteArrayInputStream.read());
    }
}
