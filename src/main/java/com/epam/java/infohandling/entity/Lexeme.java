package com.epam.java.infohandling.entity;

import com.epam.java.infohandling.util.ArgumentValidator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * To work with the different type of text, such if the text is word, whole sentence or arithmetic expression
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class Lexeme implements Component {

    private String value;
    private LexemeType lexemeType;

    private Lexeme(String value, LexemeType lexemeType) {
       setValue(value);
        this.lexemeType = lexemeType;
    }

    public static Lexeme word(String value){
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme expression(String value){
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    public static Lexeme sentence(String value){
        return new Lexeme(value, LexemeType.SENTENCE);
    }

    public void setValue(String value) {
        ArgumentValidator.checkForNullOrEmptyString(value,"Not allow for empty string or null string " +
                "value at Lexeme class");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public LexemeType getLexemeType() {
        return lexemeType;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public List<Component> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (this == o){
            return true;
        }

        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(value, lexeme.value) &&
                lexemeType == lexeme.lexemeType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 31;
        result = prime * result + ((value != null) ? value.hashCode() : 0);
        result = prime * result + ((lexemeType != null) ? lexemeType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "value='" + value + '\'' +
                ", lexemeType=" + lexemeType +
                '}';
    }
}
