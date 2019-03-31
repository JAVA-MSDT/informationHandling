package com.epam.java.infohandling.action;

import com.epam.java.infohandling.entity.Component;
import com.epam.java.infohandling.entity.Composite;
import com.epam.java.infohandling.util.ArgumentValidator;

import java.util.List;

/**
 * To copy the component form an object to another object.
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class ComponentCopier {

    /**
     *
     * @param component to be copied
     * @return new component object has the same values as the old object, so any change in the new object
     * will not effect the old object.
     */
    public static Component copyComponent(Component component){
        ArgumentValidator.checkForNull(component,"Not allow for a null component in ComponentCopier class ");

        List<Component> componentList = component.getChildren();
        Component composite = new Composite();
        for (Component comp : componentList){
            composite.add(comp);
        }
        return composite;
    }
}
