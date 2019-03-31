package com.epam.java.infohandling.util;

public class InfoRegex {
    public static final String WORD_PATTERN = "[a-zA-Z,:;']+([.]{3}|[!?.])?";
    public static final String EXPRESSION_PATTERN = "[\\d]+[ \\d/*+-=]+[\\d/*+-=]+";
    public static final String LEXEME_PATTERN = "(" + WORD_PATTERN + ")|(" + EXPRESSION_PATTERN + ")";

    public static final String SENTENCE_PATTERN = "[ a-zA-Z1-9,;:()*/+-]+([.]{3}|[.?!])";
    public static final String PARAGRAPH_PATTERN = "([\t]|[ ]{4})[ a-zA-Z1-9,.?!;:()*/+-]+([.?!]|[.]{3})[\n]?";

    public static final String SENTENCE_TERMINATOR = "(?<=[,.!?])";
    public static final String WORD_DELIMITER = "(?<=[—, '.!?])|(?=[—, '.!?])";
}
