package com.cbs.edu.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapIterate {
    public static void main(String[] args) {
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("1", "One");
        stringHashMap.put("2", "Two");
        stringHashMap.put("2", "TwoTest");
        stringHashMap.put("3", "Three");
        stringHashMap.put("4", "Three");
        stringHashMap.put(null, "Null");

        for (String k : stringHashMap.keySet()) {
            String key = stringHashMap.get(k);
            String value = stringHashMap.get(k);
            System.out.println(key + " - " + value);
        }

        Set<Map.Entry<String, String>> entries = stringHashMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println(key + " - " + value);
        }
    }
}
