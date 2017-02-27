package com.cbu.edu.hw_02;

/**
 * Created by Sviatoslav on 23.02.2017.
 */
public interface IMyList<T> {
    boolean add(T value);

    void add(int index, T value);

    T get(int index);

    void set(int index, T element);

    boolean contains(T value);

    T remove(int index);

    int size();
}
