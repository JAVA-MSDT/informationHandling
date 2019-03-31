package com.epam.java.infohandling;

import com.epam.java.infohandling.action.sort.SentenceLengthSorter;
import com.epam.java.infohandling.action.sort.SymbolQuantitySorter;
import com.epam.java.infohandling.action.sort.WordInSentenceSorter;
import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.io.InfoReader;
import com.epam.java.infohandling.parser.FullParser;
import com.epam.java.infohandling.parser.api.Parser;

public class Main {
    private static final String INFO_URI = "file/text.txt";

    public static void main(String[] args) {

        InfoReader reader = new InfoReader();
        String info = reader.read(INFO_URI);

        Parser fullParser = new FullParser();
        Component full = fullParser.parse(info);

        // Printing only the text after parse it and apply the expression calculating on it.
        System.out.println(full.getValue());
        System.out.println(" ======================================================= ");



        // Print the text by the sentence length in an ascending order
        SentenceLengthSorter sentenceLengthSorter = new SentenceLengthSorter();
        Component sentenceLength = sentenceLengthSorter.sortComponent(full);
        System.out.println(sentenceLength.getValue());
        System.out.println("===================");

        // Print the text by the word length in an ascending order
        WordInSentenceSorter word = new WordInSentenceSorter();
        Component wordLength = word.sortComponent(full);
        System.out.println(wordLength.getValue());
        System.out.println("===========================");

        // print the text by the choosing character
        SymbolQuantitySorter quantitySorter = new SymbolQuantitySorter('v');
        Component chara = quantitySorter.sortComponent(full);
        System.out.println(chara.getValue());
        System.out.println("===========================");


    }
}
