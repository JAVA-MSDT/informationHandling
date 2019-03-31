package com.epam.java.infohandling.entity;

import com.epam.java.infohandling.util.ArgumentValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that will hold all of our text components.
 * @Author Ahmed Samy (serenitydiver@hotmail.com)
 */
public class Composite implements Component {


    List<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        ArgumentValidator.checkForNull(component, "I's not allow for a null component in Composite class, add method");
        children.add(component);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public String getValue() {
        StringBuilder builder = new StringBuilder();
        for (Component component : children) {
            builder.append(component.getValue()).append(" ");
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (this == o){
            return true;
        }

        Composite composite = (Composite) o;
        return Objects.equals(children, composite.children);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((children != null) ? children.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Composite{" +
                "children=" + children +
                '}';
    }
}
