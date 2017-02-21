package com.cbu.edu.hw_01;

import java.util.Iterator;

/**
 * Created by Mokytojas on 2/21/2017.
 */
public class Stackable<Any> implements Iterable<Any>
{
    private Stackator<Any> stackator;

    public Stackable (Stackator<Any> s)
    {
        this.stackator = s;
    }

    public Iterator<Any> iterator()
    {
        return stackator;
    }
}
