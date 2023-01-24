package com.vaadin.training.elements.exercises.exercise1;

import com.vaadin.flow.component.ComponentEvent;
public class OrderItemChangeEvent extends ComponentEvent<OrderItemEditor> {


    public OrderItemChangeEvent(OrderItemEditor source, boolean fromClient) {
        super(source, fromClient);
    }
}
