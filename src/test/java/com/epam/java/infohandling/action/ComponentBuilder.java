package com.epam.java.infohandling.action;

import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.entity.Composite;
import com.epam.java.infohandling.entity.Lexeme;

/**
 * To return a component for a testing purposes instead of typing the same component in a different testing class
 */
public class ComponentBuilder {

    /**
     *
     * @return Ready component contain of 3 words and 1 expression to use in test
     */
    public Component component() {
        Component component = new Composite();
        Component lexeme;
        lexeme = Lexeme.word("word");
        component.add(lexeme);
        lexeme = Lexeme.word("second");
        component.add(lexeme);
        lexeme = Lexeme.word("third");
        component.add(lexeme);
        lexeme = Lexeme.expression("22 8 + 6 * 5 -");
        component.add(lexeme);
        return component;
    }

    /**
     *
     * @param text to add
     * @param text1 to add
     * @param text3 to add
     * @param expre1 to add
     * @return Ready customized component
     */
    public Component build(String text, String text1, String text3, String expre1){

        Component component = new Composite();
        Component lexeme;
        lexeme = Lexeme.word(text);
        component.add(lexeme);
        lexeme = Lexeme.word(text1);
        component.add(lexeme);
        lexeme = Lexeme.word(text3);
        component.add(lexeme);
        lexeme = Lexeme.expression(expre1);
        component.add(lexeme);
        return component;
    }
}
