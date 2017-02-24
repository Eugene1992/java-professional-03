package com.cbu.edu.hw_02;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Sviatoslav on 22.02.2017.
 */
public class MyArrayListImpl<T> implements IMyList<T> {

    private final int DEFAULT_CAPACITY = 10;
    private int size;
    private T arrList[];
    private T[] newStack;

    public MyArrayListImpl(int capacity) {
        arrList = (T[]) new Object[capacity];
        this.size = 0;
    }

    public MyArrayListImpl() {
        arrList = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void add(T value) {
        if (size >= DEFAULT_CAPACITY) {
            newStack = Arrays.copyOf(arrList, DEFAULT_CAPACITY * 3 / 2 + 1);
        } else {
            this.newStack = (T[]) new Object[DEFAULT_CAPACITY];
        }
        this.newStack[0] = value;
        size++;
        System.arraycopy(arrList, 0, newStack, 1, size());
        arrList = null;
        arrList = newStack;
        newStack = null;
    }

    @Override
    public void add(int index, T value) {
        if (size >= DEFAULT_CAPACITY) {
            newStack = Arrays.copyOf(arrList, DEFAULT_CAPACITY * 3 / 2 + 1);
        } else {
            this.newStack = (T[]) new Object[DEFAULT_CAPACITY];
        }
        System.arraycopy(arrList, 0, newStack, 0, index);
        newStack[index] = value;
        System.arraycopy(arrList, index, newStack, ++index, size());
        arrList = null;
        arrList = newStack;
        newStack = null;
        size++;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
        return arrList[index];
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
        arrList[index] = element;
    }

    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(arrList[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
        System.arraycopy(arrList, index + 1, arrList, index, size());
        size--;
    }

    @Override
    public int size() {
        return this.size;
    }

    public Iterator<T> getIterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator {
        int index = 0;

        /**
         * Method check has the following elements into the stack;
         *
         * @return true - if stack has next element; false - if stack don't has anymore element.
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Method take next element from the stack.
         *
         * @return element from next cell.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return arrList[index++];
        }
    }
}
