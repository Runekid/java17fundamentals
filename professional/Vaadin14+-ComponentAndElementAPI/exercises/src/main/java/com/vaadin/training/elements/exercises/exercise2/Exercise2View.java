package com.vaadin.training.elements.exercises.exercise2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.training.elements.exercises.MainLayout;



@PageTitle(Exercise2View.TITLE)
@Route(value = Exercise2View.ROUTE, layout = MainLayout.class)
@NpmPackage(value = "@polymer/paper-badge", version = "3.0.1")
@JsModule("@polymer/paper-badge")
public class Exercise2View extends Composite<VerticalLayout> {

    public static final String TITLE = "Exercise 2";
    public static final String ROUTE = "ex2";

    public Exercise2View() {
        //TODO add a @NpmPackage annotation to this class to add the paper badge dependency
        //TODO add a @JsModule annotation to import the paper-badge custom element

        //TODO create a span element with text "Inbox"
        Element span = ElementFactory.createSpan("Inbox");

        //TODO create an Element with the tag "paper-badge"
        Element paperBadge = new Element("paper-badge");

        //TODO set custom Style property "--paper-badge-margin-left" to "20px" for the paper-badge element.
        paperBadge.setProperty("--paper-badge-marging-left","20px");

        //TODO create a new div element and append the span and the paper-badge element into div
        Element div = new Element("div");
        div.appendChild(span,paperBadge);

        //TODO append the div element to the root element of this view.
        getElement().appendChild(div);

        //TODO create an input element
        Element input = ElementFactory.createInput();

        //TODO add a property "value" change listener that synchronizes on the input's "change" event
        //in the listener, set the "label" property of the badge to be the value of input
        input.addPropertyChangeListener("value","change", domEvent -> {
           paperBadge.setProperty("label", input.getProperty("value"));

        });


        //TODO set an initial value for the input element, like 0
        input.setProperty("value",0);
        input.addEventListener("wheel", this::handleWheel).addEventData("event.deltaY");

        //TODO create the '+' button, increase the value of input by 1 when clicked.
        Element plusButton = ElementFactory.createButton("+");
        plusButton.addEventListener("click", event -> {
            input.setProperty("value", input.getProperty("value", 0)+1);
        });

        //TODO create the '-' button, decrease the value of input by 1 when clicked.
        Element minusButton = ElementFactory.createButton("-");
        minusButton.addEventListener("click", event -> {
            input.setProperty("value", input.getProperty("value", 0)-1);
        });

        HorizontalLayout stepper = new HorizontalLayout();
        //append the input, '+' button and '-' button to the stepper horizontal layout.
        stepper.getElement().appendChild(input,plusButton,minusButton);

        getElement().appendChild(stepper.getElement());
        //TODO BONUS task: add a "wheel" event listener for the input element, so that
        //the value of input element can also be changed when user scrolls the mouse wheel.
        //"event.deltaY" is the property from wheel event that can help on this task.
        //hint: `element.addEventListener([...]).addEventData([...])`


    }
    private void handleWheel(DomEvent event) {
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
