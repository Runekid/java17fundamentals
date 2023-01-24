package com.vaadin.training.template.solutions.ex3;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;


public interface ToDoModel extends TemplateModel {

	void setToDoList(List<ToDo> toDoList);

	List<ToDo> getToDoList();

	String getNewText();

	void setNewText(String newText);
}
