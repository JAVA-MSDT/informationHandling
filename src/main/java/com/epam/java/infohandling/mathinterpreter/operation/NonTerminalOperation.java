package com.epam.java.infohandling.mathinterpreter.operation;

import com.epam.java.infohandling.mathinterpreter.ValueStack;
import com.epam.java.infohandling.util.ArgumentValidator;

/**
 * For other operation instead of ( +, -, *, / )
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class NonTerminalOperation implements MathOperation {
    private int number;

    public NonTerminalOperation(int number) {
        this.number = number;
    }

    @Override
    public void interpret(ValueStack valueStack) {
        ArgumentValidator.checkForNull(valueStack, "Not allow for a null value for the value stack in " +
                "NonTerminalOperation class");
        valueStack.pushValue(number);
    }
}
