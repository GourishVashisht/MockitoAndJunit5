package com.nagarro.demo.calculator;

public class Calculator {

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public int divide(int number1, int number2) throws Exception {
        if (number2 != 0) {
            return number1 / number2;
        } else {
            throw new Exception("The second number cannot be zero.");
        }
    }

}
