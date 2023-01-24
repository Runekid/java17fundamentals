package com.vaadin.trainings.routing;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.VaadinSession;

public class MainView extends Composite<VerticalLayout> implements RouterLayout,HasComponents, BeforeEnterObserver {
    private Div childWrapper = new Div();
    public MainView() {
        getContent().setSizeFull();

        H2 header = new H2("HEADER");
        add(header);

        HorizontalLayout mainLayout = new HorizontalLayout();
        VerticalLayout menu = new VerticalLayout();
        menu.setWidth("20%");
        menu.add(new RouterLink("Home", HomeView.class));
        menu.add(new RouterLink("Lottery",LotteryView.class));
        menu.add(new RouterLink("logout",LogoutView.class));
        mainLayout.add(menu);

        add(mainLayout);
        mainLayout.add(childWrapper);
        mainLayout.setFlexGrow(1,childWrapper);

        H2 footer = new H2("FOOTER");
        add(footer);

        getContent().setFlexGrow(1,mainLayout);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER,header);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH,mainLayout);
        getContent().setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER,footer);
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        childWrapper.getElement().appendChild(content.getElement());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (VaadinSession.getCurrent().getAttribute("userLoggedIn") == null) beforeEnterEvent.rerouteTo("login");
    }
}
