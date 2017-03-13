package com.cbs.edu.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsApi {
    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");

        strings.stream()
               .map(String::toUpperCase)
               .forEach(System.out::print);

        System.out.println();

        Stream.of("a", "b", "c", "d", "e")
              .map(String::toUpperCase)
              .forEach(System.out::print);

        System.out.println();

        String[] arr = {"a", "b", "c", "d", "e"};
        Arrays.stream(arr)
              .map(String::toUpperCase)
              .forEach(System.out::print);

        System.out.println();

        "abcde".chars()
               .forEach(System.out::print);

        System.out.println();

        Files.lines(Paths.get("src\\main\\java\\com\\cbs\\edu\\java8\\data"))
             .map(String::toUpperCase)
             .forEach(System.out::print);

    }
}
