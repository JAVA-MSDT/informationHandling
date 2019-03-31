package com.epam.java.infohandling.action.sort;

import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.entity.Composite;
import com.epam.java.infohandling.entity.Lexeme;
import com.epam.java.infohandling.parser.FullParser;
import com.epam.java.infohandling.parser.api.Parser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class SentenceLengthSorterTest {
    private static String text;
    private static Parser parser;
    private static SentenceLengthSorter sentenceLengthSorter;
    private static Component component;

    @BeforeClass
    public static void init(){
        text = "it has survived not only five centuries, but also the leap into electronic typesetting,\n" +
                " remaining essentially unchanged. It was popularised 2 4 + 6 * 2 / 3 - with the release of Letraset sheets\n" +
                " containing Lorem Ipsum passages, and more recently with desktop publishing software like aldus PageMaker including versions of\n" +
                " Lorem Ipsum.";
        parser = new FullParser();
        sentenceLengthSorter = new SentenceLengthSorter();
        component = parser.parse(text);
    }

    @Test
    public void sortComponentTestPass(){
        Component expected = rightOrder();
        Component actual = sentenceLengthSorter.sortComponent(component);

        Assert.assertEquals(expected, actual);
    }

    private Component rightOrder(){
        String st = " ";
        String sentence = " remaining essentially unchanged.";
        String sentence1 = "it has survived not only five centuries,";
        String sentence2 = " but also the leap into electronic typesetting,";
        String sentence3 = " It was popularised 15 with the release of Letraset sheets containing Lorem Ipsum passages,";
        String sentence4 = " and more recently with desktop publishing software like aldus PageMaker including versions of Lorem Ipsum.";

        Component composite =  new Composite();
        Component lexemeSentence;
        lexemeSentence = Lexeme.sentence(st);
        composite.add(lexemeSentence);
        lexemeSentence = Lexeme.sentence(sentence);
        composite.add(lexemeSentence);
        lexemeSentence = Lexeme.sentence(sentence1);
        composite.add(lexemeSentence);
        lexemeSentence = Lexeme.sentence(sentence2);
        composite.add(lexemeSentence);
        lexemeSentence = Lexeme.sentence(sentence3);
        composite.add(lexemeSentence);
        lexemeSentence = Lexeme.sentence(sentence4);
        composite.add(lexemeSentence);

        return composite;
    }

}