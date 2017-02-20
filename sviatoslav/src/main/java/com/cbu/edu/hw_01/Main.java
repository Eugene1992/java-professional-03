package com.cbu.edu.hw_01;

/**
 * Created by Sviatoslav on 20.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ImitationStack stackMethods = new ImitationStack(3);
        stackMethods.push(1000);
        stackMethods.push(1001);
        stackMethods.push(1002);
        stackMethods.push(1003);

        stackMethods.pop();
        stackMethods.pop();
        stackMethods.pop();
    }
}
