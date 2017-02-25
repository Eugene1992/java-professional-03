package com.cbu.edu.hw_02;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by Sviatoslav on 25.02.2017.
 */
public class MyArrayListImplTest {
    private MyArrayListImpl<Integer> list;
    private int array[];

    @Before

    public void setUp() {
        list = new MyArrayListImpl<>();
        list.add(5);
        array = new int[]{1, 2, 3, 4, 5};
    }

    @Test
    public void add() throws Exception {
        final boolean RESULT = list.add(823);
        assertTrue(RESULT);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addWithException() throws Exception {
        list.add(10, 12684);
    }

    @Test
    public void addSuccessfully() throws Exception {
        list.add(0, 1);
        final int RESULT = array[0];
        final int EXPECTED_RESULT = list.get(0);
        assertEquals(RESULT, EXPECTED_RESULT);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getWithException() throws Exception {
        list.get(800);
    }

    @Test
    public void getCorrect() throws Exception {
        final int EXPECTED_RESULT = array[4];
        final int RESULT = list.get(0);
        assertTrue(EXPECTED_RESULT == RESULT);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setWithException() throws Exception {
        list.set(5, 158);
    }

    @Test
    public void setCorrect() throws Exception {
        list.set(0, 1);
        final int EXPECTED_RESULT = array[0];
        final int RESULT = list.get(0);
        assertEquals(RESULT, EXPECTED_RESULT);
    }

    @Test
    public void containsTrue() throws Exception {
        final boolean RESULT = list.contains(5);
        assertTrue(RESULT);
    }

    @Test
    public void containsFalse() throws Exception {
        final boolean RESULT = list.contains(65455);
        assertFalse(RESULT);
    }

    @Test
    public void remove() throws Exception {
        final int EXPECTED_RESULT = array[4];
        final int RESULT = list.remove(0);
        assertTrue(EXPECTED_RESULT == RESULT);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeWithException() throws Exception {
        list.remove(125);
    }

    @Test
    public void size() throws Exception {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        final int EXPECTED_RESULT = array.length;
        final int RESULT = list.size();
        assertTrue(EXPECTED_RESULT == RESULT);
    }

    @Test
    public void getIterator() throws Exception {
        final Iterator<Integer> iterator = list.getIterator();
        assertNotNull(iterator);
    }

}