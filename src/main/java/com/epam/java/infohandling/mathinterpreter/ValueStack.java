package com.epam.java.infohandling.mathinterpreter;

import com.epam.java.infohandling.util.ArgumentValidator;

import java.util.ArrayDeque;

/**
 * To use latter to put value and get value for arithmetic operations
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class ValueStack {
    private ArrayDeque<Integer> value = new ArrayDeque<>();

    public void pushValue(Integer number){
        ArgumentValidator.checkForNull(number, "Number is not allow to be null in ValueStack class," +
                "add method");
        value.push(number);
    }

    public Integer popValue(){
        return value.pop();
    }
}
