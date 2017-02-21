package com.cbu.edu.hw_01;

import java.util.Iterator;

/**
 * Created by Sviatoslav on 20.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ImitationStack<Integer> stackMethods = new ImitationStack<>();
        Iterator<Integer> iterator = stackMethods.getIterator();
        stackMethods.push(1000);
        stackMethods.push(1001);
        stackMethods.push(1002);
        stackMethods.push(1003);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        stackMethods.pop();
        stackMethods.pop();
        stackMethods.pop();
    }
}
