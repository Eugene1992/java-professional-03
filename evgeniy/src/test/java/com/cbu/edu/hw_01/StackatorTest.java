package com.cbu.edu.hw_01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Mokytojas on 2/21/2017.
 */
public class StackatorTest
{
    private Stackator<String> stackator;

    @Before
    public void setUp() throws Exception
    {
        stackator = new Stackator<>();
    }

    @Test
    public void walk() throws Exception
    {
        final String ONE = "123";
        final String ABC = "Abc";
        stackator.push(ONE);
        stackator.push(ABC);
        String [] arr = new String [2];
        arr [0] = ONE;
        arr [1] = ABC;
        int counter = 2;
        for (String s : stackator.walk())
        {
            counter --;
            Assert.assertEquals(arr [counter], s);
        }
    }

    @Test
    public void push() throws Exception
    {
        final String ONE = "123";
        final String ABC = "Abc";
        stackator.push(ONE);
        stackator.push(ABC);
        String abc = stackator.pop();
        String one = stackator.pop();
        Assert.assertEquals(ABC, abc);
        Assert.assertEquals(ONE, one);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void pop() throws Exception
    {
        String x = stackator.pop();
    }

}
