package com.vaadin.training.elements.exercises.exercise1;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
import com.vaadin.training.elements.exercises.exercise1.data.DemoDataGenerator;
import com.vaadin.training.elements.exercises.exercise1.data.Product;

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

        //TODO create the product combobox, you can get some demo data from
        // DataGenerator.createProducts(5)
        productCombo = new ComboBox<>();
        productCombo.setItems(DemoDataGenerator.createProducts(3));
        productCombo.addValueChangeListener(event -> {
           updatePrice();
        });
        add(productCombo);
        //TODO create the amount text field
        amountField = new TextField("Amount");
        amountField.addValueChangeListener(event -> updatePrice());
        add(amountField);
        //TODO create the price text div.
        priceText = new Div();
        add(priceText);
        //TODO create the close button, you can use VaadinIcon.CLOSE.create() for its icon
        //add a click listener to remove the OrderItemEditor element from parent
        //and also fire a OrderItemChangeEvent
        closeButton = new Button(VaadinIcon.CLOSE.create());
        closeButton.addClickListener(event -> {
           this.parentEditor.remove(this);
           fireEvent(new OrderItemChangeEvent(this,true));
        });
        add(closeButton);

        //TODO add value change listener for the product combobox and the amount text field.
        //in the listener, you can just call the updatePrice() method.
    }

    private void updatePrice() {
        double price = getPrice();
        DecimalFormat df = new DecimalFormat("#0.00€");
        priceText.setText(df.format(price));
        //TODO fire an OrderItemChangeEvent event.
        fireEvent(new OrderItemChangeEvent(this,true));

    }

    public double getPrice() {
        int amount = 0;
        if (amountField != null && amountField.getValue() != null && !amountField.getValue().isEmpty()) {
            amount = Integer.parseInt(amountField.getValue());
        }
        double productPrice = 0;
        if (productCombo != null && productCombo.getValue() != null) {
            productPrice = productCombo.getValue().getPrice();
        }
        return amount * productPrice;
    }

    public Registration addOrderItemChangeEventListener(ComponentEventListener<OrderItemChangeEvent> listener) {
        // TODO: create a class OrderItemChangeEvent extends ComponentEvent<OrderItemEditor>
        // TODO: change this method's parameter to be of type ComponentEventListener<OrderItemChangeEvent>
        // TODO: use addListener with OrderItemChangeEvent.class and the `listener` parameter
        // TODO: return the registration returned by addListener
        return addListener(OrderItemChangeEvent.class,listener);
    }
}
