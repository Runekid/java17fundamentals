package com.vaadin.training.dnd.solutions.ex2;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dnd.GridDropLocation;
import com.vaadin.flow.component.grid.dnd.GridDropMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.training.dnd.solutions.MainLayout;

import java.util.List;

@Route(value = GridReorder.ROUTE, layout = MainLayout.class)
public class GridReorder extends VerticalLayout {
    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";
    private Person draggedItem;

    public GridReorder() {
        List<Person> gridItems = new PersonService().getPersons();

        Grid<Person> grid = new Grid<>(Person.class);
        grid.removeAllColumns();
        grid.addColumn("name");
        grid.addColumn("email");
        grid.addColumn("age");
        grid.addColumn(TemplateRenderer.of("[[index]]")).setHeader("Order");
        grid.setSortableColumns();
        grid.setItems(gridItems);
        grid.setSelectionMode(Grid.SelectionMode.NONE);
        grid.setRowsDraggable(true);

        grid.addDragStartListener(event -> {
            draggedItem = event.getDraggedItems().get(0);
            grid.setDropMode(GridDropMode.BETWEEN);
        });

        grid.addDropListener(event -> {
            Person dropOverItem = event.getDropTargetItem().get();
            if (!dropOverItem.equals(draggedItem)) {
                gridItems.remove(draggedItem);
                int dropIndex = gridItems.indexOf(dropOverItem)
                        + (event.getDropLocation() == GridDropLocation.BELOW ? 1
                        : 0);
                gridItems.add(dropIndex, draggedItem);
                grid.getDataProvider().refreshAll();
            }
        });

        grid.addDragEndListener(event -> {
            draggedItem = null;
            grid.setDropMode(null);
        });

        add(grid);
    }
}
