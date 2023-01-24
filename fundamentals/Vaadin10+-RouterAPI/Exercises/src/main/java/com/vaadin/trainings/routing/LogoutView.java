package com.vaadin.trainings.routing;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(value = "logout",layout = MainView.class)
public class LogoutView extends Div {

    public LogoutView() {
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().getPage().executeJavaScript("window.location.href=''");
    }
}
