package com.vaadin.training.elements.exercises.exercise1;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class OrderEditor extends Composite<VerticalLayout> implements HasComponents, HasStyle, HasSize {
    public OrderEditor() {
        addNewOrderItemEditor();
        Button addButton = new Button();
        addButton.getElement().getStyle().set("order", (Integer.MAX_VALUE - 1) + "");
        addButton.setIcon(VaadinIcon.PLUS.create());
        addButton.addClickListener(event -> addNewOrderItemEditor());
        // TODO: add a keyboard shortcut to add a new order item with Control + Enter
        addButton.addClickShortcut(Key.ENTER,KeyModifier.CONTROL);

        add(addButton);
    }

    public double getTotalPrice() {
        return getContent().getChildren().filter(component -> component instanceof OrderItemEditor).
                map(OrderItemEditor.class::cast).
                map(OrderItemEditor::getPrice).mapToDouble(Double::doubleValue).sum();
    }

    private void addNewOrderItemEditor() {
        OrderItemEditor orderItemEditor = new OrderItemEditor(this);
        orderItemEditor.addOrderItemChangeEventListener(event -> fireEvent(new OrderChangeEvent(this, true)));
        add(orderItemEditor);
    }

    public Registration addOrderChangeEventListener(ComponentEventListener<OrderChangeEvent> listener) {
        return addListener(OrderChangeEvent.class, listener);
    }
}
