package com.cbs.edu.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Spliterator;

public class Main {
    public static void main(String[] args) {
        HashSet<String> strings = new HashSet<>();

        strings.add("1");
        strings.add("1");
        strings.add("2");
        strings.add("2");
        strings.add("3");
        strings.add("3");
        strings.add("1");
        strings.add("3");
        strings.add("1");

        System.out.println(strings);

        LinkedHashSet<String> linkedStrings = new LinkedHashSet<>();

        linkedStrings.add("3");
        linkedStrings.add("1");
        linkedStrings.add("2");

        System.out.println(linkedStrings);
    }
}
