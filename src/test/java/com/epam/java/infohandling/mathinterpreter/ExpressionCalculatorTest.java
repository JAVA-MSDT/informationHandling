package com.epam.java.infohandling.mathinterpreter;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionCalculatorTest {
    private static final String EXPRESSION = "22 8 + 6 * 5 -";
    private static final int EXPECTED_RESULT = 175;

    @Test
    public void calculate() {

        ExpressionCalculator expressionCalculator = new ExpressionCalculator(EXPRESSION);


        int result = expressionCalculator.calculate();


        Assert.assertEquals(EXPECTED_RESULT, result);
    }
}
