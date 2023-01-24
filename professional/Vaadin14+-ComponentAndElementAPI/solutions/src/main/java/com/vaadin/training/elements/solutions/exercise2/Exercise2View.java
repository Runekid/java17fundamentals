package com.vaadin.training.elements.solutions.exercise2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.elements.solutions.MainLayout;

@PageTitle(Exercise2View.TITLE)
@Route(value = Exercise2View.ROUTE, layout = MainLayout.class)
@JsModule("@polymer/paper-badge")
@NpmPackage(value = "@polymer/paper-badge", version = "3.0.1")
public class Exercise2View extends Composite<VerticalLayout> {

	public static final String TITLE = "Exercise 2";
	public static final String ROUTE = "ex2";

	public Exercise2View(){
		Element container = ElementFactory.createDiv();

		Element span = ElementFactory.createSpan("Inbox");
		Element badge = new Element("paper-badge");
		badge.getStyle().set("--paper-badge-margin-left", "20px");
		container.appendChild(span, badge);

		getElement().appendChild(container);

		Element input = ElementFactory.createInput();
		input.addPropertyChangeListener("value", "change", event -> {
			badge.setProperty("label", input.getProperty("value"));
		});
		input.setProperty("value", 0);
		input.addEventListener("wheel", this::handleWheel).addEventData("event.deltaY");
		Element moreButton = ElementFactory.createButton("+");
		moreButton.addEventListener("click", event -> {
			input.setProperty("value", input.getProperty("value", 0)+1);
		});
		Element lessButton = ElementFactory.createButton("-");
		lessButton.addEventListener("click", event -> {
			input.setProperty("value", input.getProperty("value", 0)-1);
		});
		HorizontalLayout stepper = new HorizontalLayout();
		stepper.getElement().appendChild(input, moreButton, lessButton);
		getElement().appendChild(stepper.getElement());
	}

	private void handleWheel(DomEvent event){
		int delta = (int) event.getEventData().getNumber("event.deltaY");
		// deltaY is usually some hundreds -> add +-3
		int addedValue;
		if (delta >= 0) {
			addedValue = 3;
		} else {
			addedValue = -3;
		}
		event.getSource().setProperty("value", event.getSource().getProperty("value", 0)+addedValue);
	}
}
