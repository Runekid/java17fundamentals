package com.vaadin.training.template.exercises.ex3;


import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;

public interface ToDoModel extends TemplateModel {

	//TODO: create a getter/setter of a List, which would be used for holding the todo list
    List<ToDo> getToDoList();
    void setToDoList(List<ToDo> aTodoList);
	//TODO: create a getter/setter of a String, which would be used for holding the new todo text
    String getText();
    void setText(String text);
}
