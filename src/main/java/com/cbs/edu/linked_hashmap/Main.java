package com.cbs.edu.linked_hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(41, "Four");
        linkedHashMap.put(11, "One");
        linkedHashMap.put(32, "Three");
        linkedHashMap.put(23, "Two");

        System.out.println(linkedHashMap);

        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(41, "Four");
        hashMap.put(11, "One");
        hashMap.put(32, "Three");
        hashMap.put(23, "Two");
        hashMap.put(54, "Five");

        System.out.println(hashMap);
    }
}
