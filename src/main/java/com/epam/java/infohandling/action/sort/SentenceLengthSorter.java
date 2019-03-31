package com.epam.java.infohandling.action.sort;

import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.entity.Composite;
import com.epam.java.infohandling.entity.Lexeme;
import com.epam.java.infohandling.util.ArgumentValidator;
import com.epam.java.infohandling.util.InfoRegex;

import java.util.Comparator;
import java.util.List;

/**
 * Sort the text using the length of a sentence.
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class SentenceLengthSorter implements ComponentSorter {

    /**
     *
     * @param component to be sorted by the sentence length
     * @return new sorted component by the sentence length in an ascending order
     */
    @Override
    public Component sortComponent(Component component) {
        ArgumentValidator.checkForNull(component, "it is not allow for null component in the SentenceLengthSorter" +
                " class,sortComponent method");

        Component composite = buildSentence(component);
        List<Component> componentList = composite.getChildren();
        componentList.sort(new Comparator<Component>() {
            @Override
            public int compare(Component o1, Component o2) {
                return o1.getValue().length() - o2.getValue().length();
            }
        });
        return composite;
    }

    /**
     * Helper method top use it in a sort sentence in that class.
     * @param component that has a lexeme of words and expression
     * @return new component that has a lexeme of just sentence, by this way we can sort the sentence by it is length
     */
    private Component buildSentence(Component component){
        ArgumentValidator.checkForNull(component, "it is not allow for null component in the SentenceLengthSorter" +
                " class, buildSentence method");

        Component composite = new Composite();
        String text = component.getValue();
        for(String sentence : text.split(InfoRegex.SENTENCE_TERMINATOR)){
            Component lexemeSentence = Lexeme.sentence(sentence);
            composite.add(lexemeSentence);
        }
        return composite;
    }

}
