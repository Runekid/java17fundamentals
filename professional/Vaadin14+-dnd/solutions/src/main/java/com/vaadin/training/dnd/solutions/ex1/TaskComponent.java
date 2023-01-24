package com.vaadin.training.dnd.solutions.ex1;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;

import java.util.Optional;

public class TaskComponent extends Composite<Div> {

    public TaskComponent(String taskDescription) {
        Div taskLayout = getContent();

        taskLayout.addClassName("task");
        taskLayout.add(new Span(taskDescription));
        DragSource.create(this);
    }

    public DropTargetPanel getParentPanel() {
        Optional<Component> parent = getParent();

        while (parent.isPresent() && !(parent.get() instanceof DropTargetPanel)) {
            parent = parent.get().getParent();
        }
        return (DropTargetPanel) parent.get();
    }

}
