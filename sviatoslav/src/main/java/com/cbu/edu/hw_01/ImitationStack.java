package com.cbu.edu.hw_01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Sviatoslav on 20.02.2017.
 */
public class ImitationStack<T> implements IGetIterator {
    private int size;
    private T stack[];
    private int top;


    public ImitationStack(int size) {
        this.size = size;
        stack = (T[]) new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1 ? true : false;
    }

    public void push(T element) {
        if (stack.length < size) {
            int top = ++this.top;
            stack[top] = element;
        } else if (stack.length >= size) {
            T[] newStack = Arrays.copyOf(stack, size * 3 / 2 + 1);
            stack = null;
            stack = newStack;
            int top = ++this.top;
            stack[top] = element;
        }
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T element = stack[top];
            top--;
            return element;
        }
    }

    @Override
    public Iterator getIterator() {
        return (Iterator) new IteratorImpl();
    }


    private class IteratorImpl implements IIterator {
        int index = 0;

        @Override
        public boolean hasNext() {
            boolean check;
            if (index < stack.length) {
                check = true;
            } else {
                check = false;
            }
            return check;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[top++];
        }
    }
}
