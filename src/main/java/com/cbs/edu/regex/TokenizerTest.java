package com.cbs.edu.regex;

import java.util.StringTokenizer;

public class TokenizerTest {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer = new StringTokenizer("Hello world!\n Hello Earth!", ", ", true);
        while (stringTokenizer.hasMoreElements()) {
            String token = stringTokenizer.nextToken();
            System.out.println(token);
        }
    }
}
