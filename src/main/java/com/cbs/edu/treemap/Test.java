package com.cbs.edu.treemap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        NavigableMap<Integer, String > treeMap = new TreeMap<>();

        treeMap.put(1, "one");
        treeMap.put(2, "two");
        treeMap.put(3, "three");
        treeMap.put(null, "four");


    }
}
