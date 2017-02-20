package com.cbu.edu.hw_01;


/**
 * Created by Sviatoslav on 20.02.2017.
 */
public interface IIterator<E> {
    boolean hasNext();

    E next();

    void remove();

}
