package com.vaadin.training.dnd.exercises.ex1;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import jdk.internal.org.jline.utils.ShutdownHooks;

import java.util.Optional;

public class TaskComponent extends Composite<Div>{

    private final DragSource<TaskComponent> dragSource;
    public TaskComponent(String taskDescription) {
        Div taskLayout = getContent();

        taskLayout.addClassName("task");
        taskLayout.add(new Span(taskDescription));
        this.dragSource = DragSource.create(this);
    }

    public DropTargetPanel getParentPanel() {
        Optional<Component> parent = getParent();

        while (parent.isPresent() && !(parent.get() instanceof DropTargetPanel)) {
            parent = parent.get().getParent();
        }
        return (DropTargetPanel) parent.get();
    }

    public DragSource<TaskComponent> getDragSource() {
        return dragSource;
    }
}
