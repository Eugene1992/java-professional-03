package com.cbs.edu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HW1Test {

    private HW1 hw1;

    @Before
    public void setUp() {
        hw1 = new HW1();
    }

    @Test
    public void plusTest() throws Exception {
        final int ARG_ONE = 10;
        final int ARG_TWO = 20;
        final int EXPECTED = 40;
        final int ACTUAL = hw1.plus(ARG_ONE, ARG_TWO);
        Assert.assertEquals(EXPECTED, ACTUAL);
    }
}