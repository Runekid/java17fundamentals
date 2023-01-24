package com.vaadin.training.template.exercises.ex3;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.training.template.exercises.MainLayout;

import java.util.List;

@Tag("todo-view")
@NpmPackage(value="@polymer/paper-input", version = "3.0.2")
@JsModule("./src/todo-view.js")
@Route(value = ToDoView.ROUTE, layout = MainLayout.class)
public class ToDoView extends PolymerTemplate<ToDoModel> {
	public static final String ROUTE = "ex3";
	public static final String TITLE = "ToDo List";

	//TODO: add a server side method for the on-change event of paper input element.
	// the method should create a new ToDo, add it to the list and then clear the text of paper-input.
	@EventHandler
	void handleAdd() {
		ToDo toDo = new ToDo();
		toDo.setText(getModel().getText());
		getModel().getToDoList().add(toDo);
		getModel().setText("");
	}
}
