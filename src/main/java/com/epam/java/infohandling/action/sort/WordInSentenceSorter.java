package com.epam.java.infohandling.action.sort;

import com.epam.java.infohandling.action.ComponentCopier;
import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.util.ArgumentValidator;

import java.util.Comparator;
import java.util.List;

/**
 * Sort the text using the length of a word.
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class WordInSentenceSorter implements ComponentSorter {

    /**
     *
     * @param component to be sorted by the word length
     * @return sorted component in an ascending order depends on the word length
     */
    @Override
    public Component sortComponent(Component component) {
        ArgumentValidator.checkForNull(component, "it is not allow for null component in the WordInSentenceSorter class" +
                " class,sortComponent method");
        Component composite = ComponentCopier.copyComponent(component);
        List<Component> paragraph = composite.getChildren();

        paragraph.sort(new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                return o1.getValue().length() - o2.getValue().length();
            }
        });
        return composite;
    }
}
