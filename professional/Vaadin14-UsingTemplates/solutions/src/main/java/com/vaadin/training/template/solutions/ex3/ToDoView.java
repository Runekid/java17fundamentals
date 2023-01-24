package com.vaadin.training.template.solutions.ex3;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.training.template.solutions.MainLayout;

import java.util.ArrayList;
import java.util.List;

@Tag("todo-view")
@JsModule("./src/todo-view.js")
@NpmPackage(value="@polymer/paper-input", version = "3.0.2")
@Route(value = ToDoView.ROUTE, layout = MainLayout.class)
public class ToDoView extends PolymerTemplate<ToDoModel> {
	public static final String ROUTE = "ex3";
	public static final String TITLE = "ToDo List";

	@EventHandler
	private void onNewToDo() {
		final List<ToDo> newList = new ArrayList<ToDo>(getModel().getToDoList());
		newList.add(0, new ToDo(getModel().getNewText()));
		getModel().setToDoList(newList);
		getModel().setNewText("");
	}
}
