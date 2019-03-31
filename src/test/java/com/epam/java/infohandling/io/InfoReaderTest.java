package com.epam.java.infohandling.io;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class InfoReaderTest {
    private static final String INFO_URI = "file/text.txt";
    private static InfoReader reader;
    private static String expectedString;

    @BeforeClass
    public static void init(){
        reader = new InfoReader();
        expectedString = "it has survived not only five centuries, but also the leap into electronic typesetting," +
                " remaining essentially unchanged. It was popularised 2 4 + 6 * 2 / 3 - with the release of Letraset sheets" +
                " containing Lorem Ipsum passages, and more recently with desktop publishing software like aldus PageMaker including versions of" +
                " Lorem Ipsum." +
                "" +
                " it is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout." +
                " The point of using 22 8 + 6 * 5 -  Ipsum is that it has a more-or-less normal distribution of letters," +
                " as opposed to using (content here), content here,  making it look like readable English." +
                "" +
                " it is a 2 4 + 6 * 2 / 3 - established fact that a reader will be of a page when looking at its layout." +
                "" +
                " Bye.";
    }

    @Test
    public void readTestPass(){
        String actual = reader.read(INFO_URI);

        Assert.assertEquals(expectedString, actual);
    }
}
