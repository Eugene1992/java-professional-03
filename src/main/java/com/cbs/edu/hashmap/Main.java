package com.cbs.edu.hashmap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> stringHashMap2 = new HashMap<>();
        HashMap<String, String> stringHashMap = new HashMap<>(stringHashMap2);
        stringHashMap.put("1", "One");
        stringHashMap.put("2", "Two");
        stringHashMap.put("2", "TwoTest");
        stringHashMap.put("3", "Three");
        stringHashMap.put("4", "Three");
        stringHashMap.put(null, "Null");

        System.out.println(stringHashMap);

        System.out.println(stringHashMap.containsKey("1"));

        System.out.println(stringHashMap.containsValue("Null"));

        Collection<String> values = stringHashMap.values();

        System.out.println(stringHashMap.getOrDefault(null, "Default"));


    }
}
