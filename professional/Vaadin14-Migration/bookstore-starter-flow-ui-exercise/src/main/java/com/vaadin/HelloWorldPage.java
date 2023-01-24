package com.vaadin;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.samples.authentication.AccessControlFactory;
import com.vaadin.samples.authentication.flow.LoginView;

public class HelloWorldPage extends Div implements BeforeEnterObserver {
    public HelloWorldPage() {
        setText("Hello World!");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (!AccessControlFactory.getAccessControl().isUserSignedIn()) {
            beforeEnterEvent.rerouteTo(LoginView.class);
        }
    }
}
