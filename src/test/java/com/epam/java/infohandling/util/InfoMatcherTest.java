package com.epam.java.infohandling.util;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoMatcherTest {

    private static Pattern pattern;
    private static Matcher matcher;
    private static final String WORD_PATTERN = "[a-zA-Z,:;']+([.]{3}|[!?.])?";
    private static String word;

    @BeforeClass
    public static void init(){
        word = "word";
        pattern = Pattern.compile(WORD_PATTERN);
        matcher = pattern.matcher(word);
    }

    @Test
    public void matchesTestPass(){
        Matcher actual = InfoMatcher.matches(WORD_PATTERN, word);

        boolean actualMatcherResult = actual.find();
        boolean expectedMatcherResult = matcher.find();

        Assert.assertEquals(expectedMatcherResult, actualMatcherResult);
    }
}
