package com.vaadin.training.template.solutions.ex1;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = Exercise1Content.ROUTE, layout = Exercise1Layout.class)
@RouteAlias(value = "", layout = Exercise1Layout.class)
public class Exercise1Content extends Div {
	public static final String ROUTE = "ex1";
	public static final String TITLE = "@Id annotation";

	public Exercise1Content(){
		setText("I'm content, I came here with @Id annotation");
	}

}
