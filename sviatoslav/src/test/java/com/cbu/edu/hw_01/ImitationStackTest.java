package com.cbu.edu.hw_01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sviatoslav on 21.02.2017.
 */
public class ImitationStackTest {

    private ImitationStack<Integer> imitationStack;
    int arr[];

    @Before
    public void setUp() throws Exception {
        imitationStack = new ImitationStack<>();
        arr = new int[]{1};
    }

    @Test
    public void isEmptyTrue() throws Exception {
        final boolean RESULT = imitationStack.isEmpty();
        assertTrue(RESULT);
    }


    @Test
    public void isEmptyFalse() throws Exception {
        imitationStack.push(123);
        final boolean RESULT = imitationStack.isEmpty();
        assertFalse(RESULT);
    }

    @Test
    public void push() throws Exception {
        imitationStack.push(123);
        final int EXPECTED_RESULT = arr.length;
        final int RESULT = imitationStack.getLength();
        assertEquals(EXPECTED_RESULT, RESULT);
    }

    @Test
    public void pop() throws Exception {
        imitationStack.push(-1);
        imitationStack.push(2);
        imitationStack.push(4);
        imitationStack.push(8);
        imitationStack.push(1);
        final int RESULT = imitationStack.pop();
        final int EXPECTED_RESULT = arr[0];
        assertEquals(RESULT, EXPECTED_RESULT);

    }

}