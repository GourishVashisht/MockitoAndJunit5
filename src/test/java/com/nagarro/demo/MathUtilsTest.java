package com.nagarro.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MathUtilsTest {

    MathUtils mathUtils;

    @Before
    public void setUp() throws Exception {
        mathUtils = new MathUtils();
    }

    @Test
    public void shouldAddTwoNumbers() {
        int ans = mathUtils.add(10, 20);
        assertEquals(30, ans);
    }

}
