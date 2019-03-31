package com.epam.java.infohandling.entity;

import java.util.List;

public interface Component {
    void add(Component component);
    List<Component> getChildren();
    String getValue();
}
