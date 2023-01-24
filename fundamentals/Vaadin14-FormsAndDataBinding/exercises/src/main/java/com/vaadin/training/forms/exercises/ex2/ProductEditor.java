package com.vaadin.training.forms.exercises.ex2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;

import java.util.function.Consumer;

public class ProductEditor extends Composite<VerticalLayout> implements HasComponents, HasSize{
    public ProductEditor(Product product, Consumer<Product> productConsumer){
        // TODO Create a new class that extends a layout for editing the product
        final ProductFormLayout formLayout = new ProductFormLayout();
        // TODO Create a Binder and bind it together with the input fields
        // on the editor component you created. Note that after the bindings
        // have been defined, you should have the binder read the Product bean
        // given as a parameter.
        final Binder<Product> binder = new Binder<>(Product.class);
        binder.forField(formLayout.getPriceField()).withConverter(new CurrencyConverter())
                .bind(Product::getPrice, Product::setPrice);

        // Manual binding needed due to name inconsistency between UI and Bean, and lacking of @PropertyId annotation
        binder.forField(formLayout.getAvailableField()).bind(Product::getAvailable, Product::setAvailable);

        // This binds the name and options fields using the @PropertyId
        // annotations in the ProductForm
        binder.bindInstanceFields(formLayout);

        // Reads the initial data from the Product bean
        binder.readBean(product);

        // TODO Create a Save button which will write the values from the binder
        // to the Product bean. A successful save should also refresh the
        // read-only view
        final HorizontalLayout footer = new HorizontalLayout();

        footer.add(new Button("Save", event -> {
            try {
                binder.writeBean(product);
                // Refreshes the read-only view on successful save
                productConsumer.accept(product);
            } catch (final ValidationException e) {
                e.printStackTrace();
            }
        }));
        // TODO Create a Cancel button which will read the values from the
        // Product bean to the binder
        footer.add(new Button("Cancel", event -> binder.readBean(product)));
        footer.getThemeList().set("spacing", true);

        add(formLayout,footer);
    }
}
