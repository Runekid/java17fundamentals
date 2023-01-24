package com.vaadin.training.elements.solutions.exercise1;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
import com.vaadin.training.elements.solutions.exercise1.data.DemoDataGenerator;
import com.vaadin.training.elements.solutions.exercise1.data.Product;

import java.text.DecimalFormat;

public class OrderItemEditor extends Composite<HorizontalLayout> implements HasComponents, HasSize {

    private ComboBox<Product> productCombo;
    private TextField amountField;
    private Div priceText;
    private Button closeButton;

    private OrderEditor parentEditor;

    public OrderItemEditor(OrderEditor parentEditor) {
        this.parentEditor = parentEditor;
        getContent().setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        productCombo = new ComboBox<>();
        productCombo.setItems(DemoDataGenerator.createProducts(5));

        amountField = new TextField();
        amountField.setWidth("3em");

        priceText = new Div();
        priceText.setText("0€");
        priceText.getStyle().set("text-align", "right");
        priceText.setWidth("5em");

        closeButton = new Button();
        closeButton.setIcon(VaadinIcon.CLOSE.create());
        closeButton.addClickListener(event -> {
            parentEditor.remove(this);
            fireEvent(new OrderItemChangeEvent(this, true));
        });

        add(productCombo, amountField, priceText, closeButton);

        productCombo.addValueChangeListener(event -> updatePrice());
        amountField.addValueChangeListener(event -> updatePrice());
    }

    private void updatePrice() {
        double price = getPrice();
        DecimalFormat df = new DecimalFormat("#0.00€");
        priceText.setText(df.format(price));
        fireEvent(new OrderItemChangeEvent(this, true));
    }

    public double getPrice() {
        int amount = 0;
        if (amountField.getValue() != null && !amountField.getValue().isEmpty()) {
            amount = Integer.parseInt(amountField.getValue());
        }
        double productPrice = 0;
        if (productCombo.getValue() != null) {
            productPrice = productCombo.getValue().getPrice();
        }
        return amount * productPrice;
    }

    public Registration addOrderItemChangeEventListener(ComponentEventListener<OrderItemChangeEvent> listener) {
        return addListener(OrderItemChangeEvent.class, listener);
    }
}
