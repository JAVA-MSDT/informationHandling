package com.epam.java.infohandling.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoMatcher {

    public static Matcher matches(String regex, String toBeMatched){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(toBeMatched);
    }

}
