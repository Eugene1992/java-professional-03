package com.cbu.edu.hw_02;

import com.cbu.edu.hw_01.ImitationStack;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Sviatoslav on 25.02.2017.
 */
public class IteratorImplTest {
    private ImitationStack<Integer> fillingStack;
    private ImitationStack<String> emptyStack;

    @Before
    public void setUp() throws Exception {
        fillingStack = new ImitationStack<>();
        fillingStack.push(147);
        fillingStack.push(252);
        fillingStack.push(343);
        fillingStack.push(7863);
        fillingStack.push(313453);

        emptyStack = new ImitationStack<>();

    }

    @Test
    public void hasNextTrue() throws Exception {
        final boolean RESULT = fillingStack.getIterator().hasNext();
        assertTrue(RESULT);
    }

    @Test
    public void hasNextFalse() throws Exception {
        final boolean RESULT = emptyStack.getIterator().hasNext();
        assertFalse(RESULT);
    }

    @Test
    public void next() throws Exception {
        if (fillingStack.getIterator().hasNext()) {
            final int RESULT = fillingStack.getIterator().next();
            final int EXPECTED_RESULT = 147;
            assertEquals(RESULT, EXPECTED_RESULT);
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void nextError() throws Exception {
        emptyStack.getIterator().next();
    }

}