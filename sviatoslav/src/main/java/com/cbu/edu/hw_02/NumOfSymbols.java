package com.cbu.edu.hw_02;

import java.util.HashMap;

/**
 * Created by Sviatoslav on 25.02.2017.
 */
public class NumOfSymbols {
    public static void main(String[] args) {
        String str = "Hello World!!! Goodbye World";
        NumOfSymbols symbols = new NumOfSymbols(str);
        symbols.putToMap();

        for (Character key : symbols.map.keySet()) {
            System.out.println("Symbol: " + key + " Number of repetitions: " + symbols.map.get(key));
        }
    }

    private HashMap<Character, Integer> map;
    private String string;

    private NumOfSymbols(String string) {
        this.map = new HashMap<>();
        this.string = string;
    }

    private int countSymbols(char symbol) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == symbol) {
                count++;
            }
        }
        return count;
    }

    private void putToMap() {
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (map.containsKey(ch)) {
                continue;
            }
            map.put(ch, countSymbols(ch));
        }
    }
}
