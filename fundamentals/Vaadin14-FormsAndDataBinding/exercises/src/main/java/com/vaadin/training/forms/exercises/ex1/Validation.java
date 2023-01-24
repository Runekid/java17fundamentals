package com.vaadin.training.forms.exercises.ex1;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.data.validator.StringLengthValidator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.forms.exercises.MainLayout;

@Route(value = Validation.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class Validation extends VerticalLayout implements HasSize {

    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ex1";
    public static final String TITLE = "Validation";

    public Validation() {
        // TODO Create a bean class to contain the data with fields, getters and
        // setters for each value needed to bind the three TextFields.

        // TODO Create a Binder typed for the bean class you just created
        Binder<Person> binder = new Binder<>(Person.class);

        // TODO Bind field and add validation to check that the input is a
        // proper mail address.
        final EmailField emailField = new EmailField("Email validator");
        binder.forField(emailField)
                .withValidator(new EmailValidator("email is invalid"))
                .bind(Person::getEmail, Person::setEmail);

        // TODO Bind field and add validation which accepts strings between 1
        // and 10 in length
        final TextField stringField = new TextField("String length validator");
        binder.forField(stringField)
                .withValidator(new StringLengthValidator("string must be between 1 and 10 in length", 1, 10))
                .bind(Person::getString, Person::setString);

        // TODO Bind field and add a custom Validator which only accepts
        // "Vaadin"
        final TextField vaadinField = new TextField("Vaadin validator");
        binder.forField(vaadinField)
                .withValidator((s, context) -> {
                    if (s == null || s.isEmpty() || s.equals("Vaadin")) {
                        return ValidationResult.ok();
                    } else {
                        return ValidationResult.error(s + " not accepted");
                    }
                })
                .bind(Person::getVaadin, Person::setVaadin);

        add(emailField, stringField, vaadinField);

    }

}