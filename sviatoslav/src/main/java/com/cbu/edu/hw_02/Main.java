package com.cbu.edu.hw_02;

import java.util.Iterator;

/**
 * Created by Sviatoslav on 23.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayListImpl<Integer> arrayList = new MyArrayListImpl<>();
        Iterator<Integer> iter = arrayList.getIterator();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(0, 5);

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
