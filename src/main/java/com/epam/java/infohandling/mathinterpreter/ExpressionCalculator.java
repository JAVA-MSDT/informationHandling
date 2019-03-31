package com.epam.java.infohandling.mathinterpreter;

import com.epam.java.infohandling.mathinterpreter.operation.*;
import com.epam.java.infohandling.util.ArgumentValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * To calculate the expression depends on the operation of calculation.
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class ExpressionCalculator {
    private List<MathOperation> mathOperation;

    public ExpressionCalculator(String expression) {
        mathOperation = new ArrayList<>();
        operationParser(expression);
    }


    private void operationParser(String expression) {
        ArgumentValidator.checkForNullOrEmptyString(expression, "expression not allow to be null in ExpressionCalculator");
        for (String operation : expression.split(" ")) {
            if (operation.isEmpty()) {
                continue;
            }

            switch (operation) {
                case "+":
                    mathOperation.add(new Addition());
                    break;
                case "-":
                    mathOperation.add(new Subtraction());
                    break;
                case "*":
                    mathOperation.add(new Multiplication());
                    break;
                case "/":
                    mathOperation.add(new Division());
                    break;
                default:
                    Scanner scanner = new Scanner(operation);
                    if(scanner.hasNextInt()){
                        mathOperation.add(new NonTerminalOperation(scanner.nextInt()));
                    }
                    break;
            }
        }
    }

    public int calculate() {
        ValueStack valueStack = new ValueStack();
        for (MathOperation mathOperation : mathOperation) {
            mathOperation.interpret(valueStack);
        }
        return valueStack.popValue();
    }
}
