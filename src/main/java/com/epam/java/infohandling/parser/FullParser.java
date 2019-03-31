package com.epam.java.infohandling.parser;

import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.entity.Composite;
import com.epam.java.infohandling.entity.Lexeme;
import com.epam.java.infohandling.mathinterpreter.ExpressionCalculator;
import com.epam.java.infohandling.parser.api.AbstractParser;
import com.epam.java.infohandling.util.ArgumentValidator;
import com.epam.java.infohandling.util.InfoMatcher;
import com.epam.java.infohandling.util.InfoRegex;

import java.util.regex.Matcher;

/**
 * Parsing the text in total without using chain of parsing.
 */
public class FullParser extends AbstractParser {

    @Override
    public Component parse(String text) {
        ArgumentValidator.checkForNullOrEmptyString(text, "It's not allow for a null or empty text in " +
                "FullParser class");

        Component component = new Composite();
        Component lexemeComponent = new Composite();

        for (String paragraph : text.split(InfoRegex.PARAGRAPH_PATTERN)) {

            for (String sentence : paragraph.split(InfoRegex.SENTENCE_TERMINATOR)) {
                Matcher lexemeMatcher = InfoMatcher.matches(InfoRegex.LEXEME_PATTERN, sentence);
                while (lexemeMatcher.find()) {

                    String lexeme = lexemeMatcher.group();
                    if (lexeme.matches(InfoRegex.WORD_PATTERN)) {
                        lexemeComponent = Lexeme.word(lexeme);
                    } else if (lexeme.matches(InfoRegex.EXPRESSION_PATTERN)) {
                        ExpressionCalculator expressionCalculator = new ExpressionCalculator(lexeme);
                        lexemeComponent = Lexeme.expression(String.valueOf(expressionCalculator.calculate()));

                    }
                    component.add(lexemeComponent);
                }
            }

        }
        return component;
    }
}
