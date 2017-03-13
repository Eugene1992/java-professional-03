package com.cbs.edu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[\\w]{3,20}@[a-z]{3,10}(\\.[a-z]{1,3}){1,2}");

//        8(093)190-77-18

        Matcher matcher = pattern.matcher("deyneko55@gmail.com.ua");

        System.out.println(matcher.matches());
    }
}
