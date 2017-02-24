package com.cbu.edu.hw_02;

/**
 * Created by Sviatoslav on 23.02.2017.
 */
public interface IMyList<T> {
    void add(T value);

    void add(int index, T value);

    T get(int index);

    void set(int index, T element);

    boolean contains(T value);

    void remove(int index);

    int size();
}
