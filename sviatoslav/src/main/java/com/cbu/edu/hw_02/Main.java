package com.cbu.edu.hw_02;

import java.util.Arrays;
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
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(2, 6);
        arrayList.set(3, 7);
        arrayList.remove(2);
        System.out.println(arrayList.contains(88888));
        System.out.println(arrayList.size());

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
