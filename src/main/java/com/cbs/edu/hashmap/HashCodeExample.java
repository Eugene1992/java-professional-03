package com.cbs.edu.hashmap;

public class HashCodeExample {
    public static void main(String[] args) {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();

        System.out.println(first.hashCode());
        System.out.println(second.hashCode());
        System.out.println(third.hashCode());
    }
}
