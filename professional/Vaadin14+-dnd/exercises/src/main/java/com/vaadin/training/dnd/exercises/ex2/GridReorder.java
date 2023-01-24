package com.vaadin.training.dnd.exercises.ex2;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dnd.GridDropLocation;
import com.vaadin.flow.component.grid.dnd.GridDropMode;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.training.dnd.exercises.MainLayout;

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
            // TODO: store the event's dragged item into the `draggedItem` variable
            draggedItem = event.getDraggedItems().get(0);
            // TODO: set the Grid's drop mode to e.g. `BETWEEN`
            grid.setDropMode(GridDropMode.BETWEEN);
        });

        grid.addDropListener(event -> {
            // TODO: get the event's drop target item. If it's not the dragged item:
            Person dropOverItem = event.getDropTargetItem().get();
            if (draggedItem != dropOverItem) {
                // TODO: * remove the dragged item from `gridItems`
                gridItems.remove(draggedItem);
                // TODO: * find out what's the drop target item's index in `gridItems`
                int dropIndex = gridItems.indexOf(dropOverItem);
                // TODO: * add the dragged item back into `gridItems` with the index
                if (event.getDropLocation() == GridDropLocation.BELOW) {
                    dropIndex++;
                }
                gridItems.add(dropIndex, draggedItem);
                // TODO: * call `refreshAll()` on the grid's DataProvider
                grid.getDataProvider().refreshAll();
            }
        });

        grid.addDragEndListener(event -> {
            // TODO: reset the `draggedItem` to nothing
            // TODO: set the Grid's drop mode to `null`
            draggedItem = null;
            grid.setDropMode(null);
        });

        add(grid);
    }
}
