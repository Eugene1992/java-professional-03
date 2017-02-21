package com.cbu.edu.hw_01;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Sviatoslav on 21.02.2017.
 */
public class IteratorImplTest {
    private ImitationStack<Integer> testHasNext;
    private ImitationStack<String> imitationStack;

    @Before
    public void setUp() throws Exception {
        testHasNext = new ImitationStack<>();
        testHasNext.push(147);
        testHasNext.push(252);
        testHasNext.push(343);
        testHasNext.push(7863);
        testHasNext.push(313453);

        imitationStack = new ImitationStack<>();

    }

    @Test
    public void hasNextTrue() throws Exception {
        final boolean RESULT = testHasNext.getIterator().hasNext();
        assertTrue(RESULT);
    }

    @Test
    public void hasNextFalse() throws Exception {
        final boolean RESULT = imitationStack.getIterator().hasNext();
        assertFalse(RESULT);
    }

    @Test
    public void next() throws Exception {
        if (testHasNext.getIterator().hasNext()) {
            final int RESULT = (int) testHasNext.getIterator().next();
            final int EXPECTED_RESULT = 147;
            assertEquals(RESULT, EXPECTED_RESULT);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void nextError() throws Exception {
        imitationStack.getIterator().next();
    }

}