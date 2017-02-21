package com.cbu.edu.hw_01;


/**
 * Created by Sviatoslav on 20.02.2017.
 */
public interface IIterator<T> {
    boolean hasNext();

    T next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

}
