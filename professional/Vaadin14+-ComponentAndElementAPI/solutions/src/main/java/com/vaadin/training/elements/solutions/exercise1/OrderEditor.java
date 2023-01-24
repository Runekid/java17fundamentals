package com.vaadin.training.elements.solutions.exercise1;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyModifier;
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
        addButton.addClickShortcut(Key.ENTER, KeyModifier.CONTROL);

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
