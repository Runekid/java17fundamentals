package com.vaadin.training.elements.solutions;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.training.elements.solutions.exercise1.Exercise1View;
import com.vaadin.training.elements.solutions.exercise2.Exercise2View;

public class MainLayout extends AppLayout {

    public MainLayout() {

        addToNavbar(new DrawerToggle(), new H2("Component and Element API Exercise"));

        final VerticalLayout menuBar = new VerticalLayout();
        menuBar.add(new RouterLink(Exercise1View.TITLE, Exercise1View.class));
        menuBar.add(new RouterLink(Exercise2View.TITLE, Exercise2View.class));
        addToDrawer(menuBar);
    }
}
