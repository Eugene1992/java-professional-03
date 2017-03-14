package com.cbu.edu.hw_01;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Stackator testing engine
 */
public class StackatorTest
{
    final String ONE = "123";
    final String ABC = "Abc";
    final String XYZ = "@#^";

    private Stackable<String> Stackable;

    @Before
    public void setUp() throws Exception
    {
        Stackable = new Stackable<>();
    }

    private String[] walkInitArray ()
    {
        String [] arr = new String [3];
        arr [0] = ONE;
        arr [1] = ABC;
        arr [2] = XYZ;
        return arr;
    }

    private void walkPushArray (String [] arr)
    {
        for (int j = 0; j < arr.length; j ++)
            Stackable.push(arr [j]);
    }

    @Test
    public void walk1() throws Exception
    {
        String [] arr = walkInitArray();
        walkPushArray(arr);

        int counter = arr.length;
        int total = 0;
        for (String s : Stackable)
        {
            counter --;
            Assert.assertEquals(arr [counter], s);
            total ++;
        }
        Assert.assertEquals(arr.length, total);
    }

    @Test
    public void walk2() throws Exception
    {
        String [] arr = walkInitArray();
        walkPushArray(arr);
        int total = 0;
        int counter1 = arr.length;
        for (String s1 : Stackable)
        {
            counter1 --;
            Assert.assertEquals(arr [counter1], s1);
            int counter2 = arr.length;
            for (String s2 : Stackable)
            {
                counter2 --;
                Assert.assertEquals(arr [counter2], s2);
                total ++;
            }
        }
        Assert.assertEquals(arr.length * arr.length, total);
    }

    @Test
    public void push() throws Exception
    {
        Stackable.push(ONE);
        Stackable.push(ABC);
        String abc = Stackable.pop();
        String one = Stackable.pop();
        Assert.assertEquals(ABC, abc);
        Assert.assertEquals(ONE, one);
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void pop() throws Exception
    {
        Stackable.pop();
    }

}
