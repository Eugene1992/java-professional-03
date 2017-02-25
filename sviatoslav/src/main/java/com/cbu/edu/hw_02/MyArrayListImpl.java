package com.cbu.edu.hw_02;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Resizable-array implementation of the IMyList interface.
 * Include option of adding, getting, setting, removing.
 */

public class MyArrayListImpl<T> implements IMyList<T> {

    private final static int DEFAULT_CAPACITY = 10;
    private int size;
    private T arrList[];

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param capacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public MyArrayListImpl(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        arrList = (T[]) new Object[capacity];
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public MyArrayListImpl() {
        arrList = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param value element to be appended to this list;
     * @return true if element successfully added to list.
     */
    @Override
    public boolean add(T value) {
        increaseCapacity();
        arrList[size++] = value;
        return true;
    }

    /**
     * Insert specified position specified value into this list;
     *
     * @param index index for which specified value;
     * @param value value, what will be insert.
     * @throws IndexOutOfBoundsException if index less than zero or more size of the List.
     */
    @Override
    public void add(int index, T value) {
        increaseCapacity();
        checkRange(index);
        System.arraycopy(arrList, index, arrList, ++index, size++);
        arrList[--index] = value;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if index less than zero or more size of the List.
     */
    @Override
    public T get(int index) {
        checkRange(index);
        return arrList[index];
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index   index of the element to replace;
     * @param element element to be stored at the specified position;
     * @throws IndexOutOfBoundsException if index less than zero or more size of the List.
     */
    @Override
    public void set(int index, T element) {
        checkRange(index);
        arrList[index] = element;
    }

    /**
     * Returns true if this list contains the specified element
     *
     * @param value element whose presence in this list is to be tested
     * @return true, if this list contains the specified element
     */
    @Override
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(arrList[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @throws IndexOutOfBoundsException if index less than zero or more size of the List.
     */
    @Override
    public T remove(int index) {
        checkRange(index);
        T oldValue = arrList[index];
        System.arraycopy(arrList, index++, arrList, index, size);
        size--;
        return oldValue;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @param index position on list.
     * @throws IndexOutOfBoundsException if index less than zero or more size of the List.
     */
    private void checkRange(int index) {
        if (index < 0 || index >= this.size)
            throw new IndexOutOfBoundsException();
    }

    private void increaseCapacity() {
        if (size == DEFAULT_CAPACITY) {
            arrList = Arrays.copyOf(arrList, DEFAULT_CAPACITY * 3 / 2 + 1);
        }
    }

    public Iterator<T> getIterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<T> {
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
