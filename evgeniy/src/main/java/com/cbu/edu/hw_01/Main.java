package com.cbu.edu.hw_01;

public class Main
{
    public static void main(String[] args)
    {
        Stackator<String> stack = new Stackator<>();
        stack.push ("One");
        stack.push ("Two");
        stack.push ("Five");

        System.out.println("--- Walk ---");
        for (String s : stack.walk())
            System.out.println(s);

        System.out.println("--- Pops ---");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
