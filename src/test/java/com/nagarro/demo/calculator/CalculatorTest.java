package com.nagarro.demo.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldMultiplyTwoPositiveNumbersAndReturnAPositiveNumber() {
        int ans = calculator.multiply(20, 10);
        assertEquals(200, ans);
    }

    @Test
    public void shouldMultiplyTwoNegativeNumbersAndReturnAPositiveNumber() {
        int ans = calculator.multiply(-20, -10);
        assertEquals(200, ans);
    }

    @Test
    public void shouldMultiplyOnePositiveAndOneNegativeNumberAndReturnANegativeNumber() {
        int ans = calculator.multiply(-20, 10);
        assertEquals(-200, ans);
    }

    @Test
    public void shouldMultiplyOnePoisitiveNumberWithZeroAndReturnZero() {
        int ans = calculator.multiply(20, 0);
        assertEquals(0, ans);
    }

    @Test
    public void shouldDivideTwoNonZeroPositiveNumbers() throws Exception {
        int ans = calculator.divide(20, 10);
        assertEquals(2, ans);
    }

    @Test
    public void shouldDivideTwoNonZeroNegativeNumbers() throws Exception {
        int ans = calculator.divide(-20, -10);
        assertEquals(2, ans);
    }

    @Test
    public void shouldDivideOneNegativeAndOnePositiveNumber() throws Exception {
        int ans = calculator.divide(-20, 10);
        assertEquals(-2, ans);
    }

    @Test
    public void shouldThrowExceptionWhenSecondNumberIsZero() throws Exception {
        exception.expect(Exception.class);
        exception.expectMessage("The second number cannot be zero.");
        int ans = calculator.divide(20, 0);
    }

}
