package com.epam.java.infohandling.action.sort;

import com.epam.java.infohandling.action.ComponentCopier;
import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.util.ArgumentValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;

/**
 * Sort the text using the quantity of a given character in the text.
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class SymbolQuantitySorter implements ComponentSorter {

    private char symbol;

    public SymbolQuantitySorter(char symbol){
        this.symbol = symbol;
    }

    /**
     *
     * @param component to be sorted by the quantity of a given character in the text
     * @return component sorted in an ascending order depends on the quantity of  a given character,
     * you will the find the words that have this character at the end of the text sorted in an ascending order
     */
    @Override
    public Component sortComponent(Component component) {
        ArgumentValidator.checkForNull(component, "it is not allow for null component in the SymbolQuantitySorter" +
                " class,sortComponent method");

        Component composite = ComponentCopier.copyComponent(component);
        List<Component> paragraphs = composite.getChildren();
        paragraphs.sort(new Comparator<Component>() {
            @Override
            public int compare(Component firstLexeme, Component secondLexeme) {

                String firstLexemeValue = firstLexeme.getValue();
                String secondLexemeValue = secondLexeme.getValue();

                int firstSymbolOccurrenceCounter =
                        StringUtils.countMatches(firstLexemeValue, String.valueOf(symbol));
                int secondSymbolOccurrenceCounter =
                        StringUtils.countMatches(secondLexemeValue, String.valueOf(symbol));

                if (firstSymbolOccurrenceCounter != secondSymbolOccurrenceCounter) {
                    return  firstSymbolOccurrenceCounter - secondSymbolOccurrenceCounter;
                }

                return secondLexemeValue.compareToIgnoreCase(firstLexemeValue);
            }
        });
        return composite;
    }
}
