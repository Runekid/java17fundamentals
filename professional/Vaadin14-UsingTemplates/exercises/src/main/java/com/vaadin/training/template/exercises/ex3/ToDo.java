package com.vaadin.training.template.exercises.ex3;

import java.io.Serializable;

public class ToDo implements Serializable{
	private static final long serialVersionUID = 1318401982046635287L;

	private String text;
	private boolean done;

	public ToDo(){
	}

	public ToDo(String text) {
		this(text, false);
	}

	public ToDo(String text, boolean done) {
		this.text = text;
		this.done = done;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
