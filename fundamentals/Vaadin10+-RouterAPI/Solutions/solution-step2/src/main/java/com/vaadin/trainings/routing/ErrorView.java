package com.vaadin.trainings.routing;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;

public class ErrorView extends Div  implements HasErrorParameter<InvalidValueExeption> {
    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<InvalidValueExeption> parameter) {
        setText("Ooops, seems it's an invalid number");
        return 500;
    }
}
