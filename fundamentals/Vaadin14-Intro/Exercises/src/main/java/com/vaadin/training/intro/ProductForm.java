package com.vaadin.training.intro;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

public class ProductForm extends VerticalLayout {
    public ProductForm() {
        TextField name = new TextField("Name");
        TextArea description = new TextArea("Description");
        NumberField price = new NumberField("Price");
        price.setSuffixComponent(new Span("€"));
        price.setStep(0.01);
        DatePicker available = new DatePicker("Available");
        ComboBox<String> category = new ComboBox<>("Category");
        category.setItems("A","B","C");
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        Button cancel = new Button("Cancel");
        Button save = new Button("Save");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        horizontalLayout.add(cancel,save);
        add(name,description,price,available,category,horizontalLayout);

    }
}
