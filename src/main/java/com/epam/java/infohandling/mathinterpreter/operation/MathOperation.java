package com.epam.java.infohandling.mathinterpreter.operation;

import com.epam.java.infohandling.mathinterpreter.ValueStack;

public interface MathOperation {
    void interpret(ValueStack valueStack);
}
