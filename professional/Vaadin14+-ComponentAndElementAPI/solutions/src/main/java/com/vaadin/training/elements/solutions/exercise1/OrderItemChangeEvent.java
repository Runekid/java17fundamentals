package com.vaadin.training.elements.solutions.exercise1;

import com.vaadin.flow.component.ComponentEvent;

public class OrderItemChangeEvent extends ComponentEvent<OrderItemEditor> {
    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source     the source component
     * @param fromClient <code>true</code> if the event originated from the client
     */
    public OrderItemChangeEvent(OrderItemEditor source, boolean fromClient) {
        super(source, fromClient);
    }
}
