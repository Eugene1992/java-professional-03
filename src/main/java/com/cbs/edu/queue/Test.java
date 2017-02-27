package com.cbs.edu.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(1);
        Integer element1 = queue.element();
        Integer element2 = queue.peek();
    }
}
