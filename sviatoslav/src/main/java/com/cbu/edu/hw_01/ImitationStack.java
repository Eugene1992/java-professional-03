package com.cbu.edu.hw_01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Sviatoslav on 20.02.2017.
 */
public class ImitationStack<T extends Number> implements IGetIterator{
    private int size;
    private T[] stack;
    private T[] newStack;
    private int top;



    public ImitationStack(int size) {
        this.size = size;
        stack = (T[])new Object[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        boolean check = false;
        if (top == -1) {
            check = true;
        }
        return check;
    }

    public void push(T element) {
        if (stack.length < size) {
            int top = ++this.top;
            stack[top] = element;
        } else if (stack.length >= size) {
            newStack = Arrays.copyOf(stack, size * 3 / 2 + 1);
            stack = null;
            stack = newStack;
            int top = ++this.top;
            stack[top] = element;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        } else {
            T element = (T) stack[top];
            top--;
            return (int) element;
        }
    }

    @Override
    public Iterator getIterator() {
        return null; // i wanted return new IteratorImpl, but i have problems with interface " IGetIterator".
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
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            return (T)stack[top++];
        }

        @Override
        public void remove() {
            //stack.
        }


    }
}
