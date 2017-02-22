package com.cbu.edu.hw_01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <T> - type of data , whose we will using in Stack.
 * @author Sviatoslav
 */
public class ImitationStack<T> {
    private int size = 10;
    private T stack[];
    private int top;
    private int length;

    /**
     * Constructor for creating instance of class, whose initialise last element in
     * stack and his total count of elements.
     */
    public ImitationStack() {
        stack = (T[]) new Object[size];
        this.top = -1;
        length = 0;
    }

    /**
     * Getter for getting count of elements.
     *
     * @return count of elements in stack.
     */
    public int getLength() {
        return length;
    }

    /**
     * Method to check availability elements in stack.
     *
     * @return true - if stack is empty;
     * false - if stack have some elements.
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Method for adding elements into the stack.
     *
     * @param element - element whose, will be put into stack.
     */
    public void push(T element) {
        if (stack.length >= size) {
            T[] newStack = Arrays.copyOf(stack, size * 3 / 2 + 1);
            stack = null;
            stack = newStack;

        }
        int top = ++this.top;
        stack[top] = element;
        length++;
    }

    /**
     * Method for taking last element into the stack. After taking element will be remove from the stack.
     *
     * @return - element on the last cell in the stack.
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T element = stack[top];
            this.length--;
            top--;
            return element;
        }
    }

    /**
     * Method for getting instance of Iterator.
     *
     * @return instance of IteratorImpl.
     */
    public Iterator<T> getIterator() {
        return new IteratorImpl();
    }

    /**
     * Class for implementing methods of iterator.
     */
    private class IteratorImpl implements Iterator {
        int index = 0;

        /**
         * Method check has the following elements into the stack;
         *
         * @return true - if stack has next element; false - if stack don't has anymore element.
         */
        @Override
        public boolean hasNext() {
            return index < length;
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
            return stack[index++];
        }
    }
}
