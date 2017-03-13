package com.cbs.edu;

public class Main {
    public static void main(String[] args) {
        String strOne = "Hello world!";
        String strTwo = "Hello world!";
        String strThree = new String("Hello world!");

        System.out.println(strOne == strTwo);
        System.out.println(strOne == strThree);

        strThree = strThree.intern();

        System.out.println(strOne == strThree);

        strOne = strOne + "!!";

        StringBuilder stringBuilder = new StringBuilder(strOne);
        stringBuilder.append("!!");
        strOne = stringBuilder.toString();

        System.out.println(stringBuilder.reverse());

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);

        String s = "";
    }
}
