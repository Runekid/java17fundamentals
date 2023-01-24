package com.vaadin.training.theming.exercises.ex2;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.training.theming.exercises.MainLayout;

@Route(value = Exercise2.ROUTE, layout = MainLayout.class)
public class Exercise2 extends HorizontalLayout {

    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    public Exercise2() {
        setSizeFull();

        ComboBox<String> normalCombo = new ComboBox<>();
        normalCombo.setItems("a", "b", "c");

        ComboBox<String> yellowBgColorCombo = new ComboBox<>();
        yellowBgColorCombo.setItems("a", "b", "c");
        yellowBgColorCombo.getElement().getThemeList().add("yellowBg");
        //TODO hide the clear button of this combobox

        add(normalCombo, yellowBgColorCombo);
    }

}