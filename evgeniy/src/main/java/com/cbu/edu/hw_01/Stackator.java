package com.cbu.edu.hw_01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Mokytojas on 2/21/2017.
 */
public class Stackator<Any> implements Iterator<Any>
{
    ArrayList<Any> list;
    int iteratorIndex;

    public Stackator()
    {
        list = new ArrayList<Any>();
    }

    public Stackable<Any> walk ()
    {
        Stackable stackable = new Stackable (this);
        initIterator();
        return stackable;
    }

    public void push (Any any)
    {
        list.add(any);
    }

    public Any pop () throws ArrayIndexOutOfBoundsException
    {
        int last = list.size() - 1;
        if (last < 0)
            throw new ArrayIndexOutOfBoundsException ("Stackator is empty");
        Any any = list.get(list.size() - 1);
        list.remove (list.size() - 1);
        return any;
    }

    private void initIterator()
    {
        iteratorIndex = list.size();
    }

    public boolean hasNext()
    {
        return iteratorIndex > 0;
    }

    public Any next()
    {
        if (!hasNext())
            throw new ArrayIndexOutOfBoundsException("Stackator iterator is closed");
        return list.get(--iteratorIndex);
    }
}
