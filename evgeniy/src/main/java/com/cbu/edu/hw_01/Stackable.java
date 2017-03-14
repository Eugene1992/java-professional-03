package com.cbu.edu.hw_01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Creating an Iterator for Stackator
 */
public class Stackable<Any> implements Iterable<Any>
{
    ArrayList<Any> list;

    public Stackable() {
        list = new ArrayList<>();
    }

    public void push(Any any) {
        list.add(any);
    }

    public Any pop() throws ArrayIndexOutOfBoundsException {
        int last = list.size() - 1;
        if (last < 0)
            throw new ArrayIndexOutOfBoundsException("Stackator is empty");
        Any any = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return any;
    }

    public Iterator<Any> iterator()
    {
        // return list.iterator(); // it is enough without inner subclass
        return new Stackator();
    }

    class Stackator implements Iterator
    {
        int index;

        public Stackator()
        {
            index = list.size();
        }

        public boolean hasNext()
        {
            return index > 0;
        }

        public Any next()
        {
            if (!hasNext())
                throw new ArrayIndexOutOfBoundsException("Stackator iterator is closed");
            Any any = list.get(--index);
            return any;
        }

    }

}
