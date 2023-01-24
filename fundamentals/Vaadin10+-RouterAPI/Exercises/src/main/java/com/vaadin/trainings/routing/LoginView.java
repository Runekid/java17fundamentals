package com.vaadin.trainings.routing;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;

@Route(value = "login")
public class LoginView extends Composite<Div> implements HasComponents {

    public LoginView() {
        Button login = new Button("Login", buttonClickEvent -> {
            VaadinSession.getCurrent().setAttribute("userLoggedIn", true);
            UI.getCurrent().navigate("");
        });
        add(login);

    }
}
