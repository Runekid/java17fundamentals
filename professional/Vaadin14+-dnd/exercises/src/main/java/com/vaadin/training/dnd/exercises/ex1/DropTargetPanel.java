package com.vaadin.training.dnd.exercises.ex1;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dnd.DropEvent;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

import java.util.Optional;

public class DropTargetPanel extends Composite<VerticalLayout> {

    private final DropTarget<VerticalLayout> dropTarget;

    public DropTargetPanel(String caption) {
        VerticalLayout content = getContent();
        content.setClassName("droptarget");
        content.setWidthFull();
        content.add(new Span(caption));
        this.dropTarget = DropTarget.create(content);

    }

    public void addComponent(TaskComponent task) {
        getContent().add(task);
    }

    public DropTarget<VerticalLayout> getDropTarget() {
        return dropTarget;
    }
}
