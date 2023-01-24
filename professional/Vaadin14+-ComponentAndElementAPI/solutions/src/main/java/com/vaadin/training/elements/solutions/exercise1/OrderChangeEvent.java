package com.vaadin.training.elements.solutions.exercise1;

import com.vaadin.flow.component.ComponentEvent;

public class OrderChangeEvent extends ComponentEvent<OrderEditor>{
    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source     the source component
     * @param fromClient <code>true</code> if the event originated from the client
     */
    public OrderChangeEvent(OrderEditor source, boolean fromClient) {
        super(source, fromClient);
    }
}
