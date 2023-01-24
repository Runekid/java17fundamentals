package com.vaadin.training.template.solutions;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.training.template.solutions.ex1.Exercise1Content;
import com.vaadin.training.template.solutions.ex2.Exercise2Content;
import com.vaadin.training.template.solutions.ex3.ToDoView;

public class MainLayout extends AppLayout {

	public MainLayout(){

		addToNavbar(new DrawerToggle(), new H2("Template Exercise"));

		final VerticalLayout menuBar = new VerticalLayout();
		menuBar.add(new RouterLink(Exercise1Content.TITLE, Exercise1Content.class));
		menuBar.add(new RouterLink(Exercise2Content.TITLE, Exercise2Content.class));
		menuBar.add(new RouterLink(ToDoView.TITLE, ToDoView.class));
		addToDrawer(menuBar);
	}
}
