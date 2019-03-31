package com.epam.java.infohandling.parser.api;

import com.epam.java.infohandling.entity.Component;

public interface Parser {
    Component parse(String text);
}
