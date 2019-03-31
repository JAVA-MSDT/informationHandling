package com.epam.java.infohandling.action.sort;

import com.epam.java.infohandling.action.ComponentBuilder;
import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.entity.Composite;
import com.epam.java.infohandling.entity.Lexeme;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SymbolQuantitySorterTest {

    private static Component component;
    private static ComponentBuilder componentBuilder;
    private static SymbolQuantitySorter symbolQuantitySorter;

    @BeforeClass
    public static void init(){
        componentBuilder = new ComponentBuilder();
        component = componentBuilder.build("time", "ttto", "ttake","45 * 5 / 8");
        symbolQuantitySorter = new SymbolQuantitySorter('t');
    }

    @Test
    public void sortComponentPass(){
        Component expected = rightSorted("45 * 5 / 8", "time", "ttake", "ttto");
        Component actual = symbolQuantitySorter.sortComponent(component);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortComponentFail(){
        Component expected = componentBuilder.build("45 * 5 / 8", "time", "ttake", "ttto");
        Component actual = symbolQuantitySorter.sortComponent(component);

        Assert.assertEquals(expected, actual);
    }


    private Component rightSorted(String expre1, String text, String text2, String text3){

        Component component = new Composite();
        Component lexeme;
        lexeme = Lexeme.expression(expre1);
        component.add(lexeme);
        lexeme = Lexeme.word(text);
        component.add(lexeme);
        lexeme = Lexeme.word(text2);
        component.add(lexeme);
        lexeme = Lexeme.word(text3);
        component.add(lexeme);

        return component;
    }
}
