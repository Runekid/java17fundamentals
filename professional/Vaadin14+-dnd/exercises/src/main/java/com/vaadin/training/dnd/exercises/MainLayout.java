package com.vaadin.training.dnd.exercises;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.training.dnd.exercises.ex1.KanbanBoard;
import com.vaadin.training.dnd.exercises.ex2.GridReorder;

@CssImport("styles/shared-styles.css")
public class MainLayout extends AppLayout {

    public MainLayout() {
        addToNavbar(new DrawerToggle());
        addToNavbar(new H2("Drag and Drop Exercise"));

        final VerticalLayout menuBar = new VerticalLayout();
        menuBar.setId("menuBar");
        menuBar.add(new RouterLink(KanbanBoard.TITLE, KanbanBoard.class));
        menuBar.add(new RouterLink(GridReorder.TITLE, GridReorder.class));
        addToDrawer(menuBar);
    }
}
