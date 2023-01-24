package com.vaadin.trainings.routing;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;

public class InvalidValueErrorView extends Div implements HasErrorParameter<InvalidValueExeption> {
    @Override
    public int setErrorParameter(BeforeEnterEvent beforeEnterEvent, ErrorParameter<InvalidValueExeption> errorParameter) {
        getElement().setText("Invalid value entered");
        return 500;
    }
}
