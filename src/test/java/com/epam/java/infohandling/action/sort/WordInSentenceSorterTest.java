package com.epam.java.infohandling.action.sort;

import com.epam.java.infohandling.action.ComponentBuilder;
import com.epam.java.infohandling.entity.Component;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordInSentenceSorterTest {

    private static Component component;
    private static ComponentBuilder componentBuilder;
    private static WordInSentenceSorter word;

    @BeforeClass
    public static void init(){
        componentBuilder = new ComponentBuilder();
        component = componentBuilder.build("first", "second", "four","45 * 5 / 8");
        word = new WordInSentenceSorter();
    }

    @Test
    public void sortComponentPass(){
        Component expected = componentBuilder.build("four", "first", "second", "45 * 5 / 8");
        Component actual = word.sortComponent(component);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortComponentFail(){
        Component expected = componentBuilder.build( "first", "second","four", "45 * 5 / 8");
        Component actual = word.sortComponent(component);

        Assert.assertEquals(expected, actual);
    }
}
