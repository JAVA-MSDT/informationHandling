package com.epam.java.infohandling.mathinterpreter.operation;

import com.epam.java.infohandling.mathinterpreter.ValueStack;
import com.epam.java.infohandling.util.ArgumentValidator;

/**
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class Multiplication implements MathOperation {
    @Override
    public void interpret(ValueStack valueStack) {
        ArgumentValidator.checkForNull(valueStack, "Not allow for a null value for the value stack in Multiplication " +
                "class");
        Integer firstValue = valueStack.popValue();
        Integer secondValue = valueStack.popValue();
        valueStack.pushValue(firstValue * secondValue);
    }
}
