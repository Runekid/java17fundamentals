package com.vaadin.training.template.exercises.ex2;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route(value = Exercise2Content.ROUTE, layout = Exercise2Layout.class)
public class Exercise2Content extends Div {
	public static final String ROUTE = "ex2";
	public static final String TITLE = "<slot>";

	public Exercise2Content(){
		setText("I'm content, I came here with <slot>");
	}

}
