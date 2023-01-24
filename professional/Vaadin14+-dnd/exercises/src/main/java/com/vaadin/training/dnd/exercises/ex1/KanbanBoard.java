package com.vaadin.training.dnd.exercises.ex1;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.dnd.exercises.MainLayout;

import java.util.Optional;

@Route(value = KanbanBoard.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class KanbanBoard extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ex1";
    public static final String TITLE = "Exercise 1";

    private DropTargetPanel todo;
    private DropTargetPanel done;
    private DropTargetPanel ongoing;

    public KanbanBoard() {
        final HorizontalLayout layout = new HorizontalLayout();
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
        add(layout);
        layout.setSizeFull();

        todo = new DropTargetPanel("TODO");
        todo.addComponent(new TaskComponent("Implement UI layer"));
        todo.addComponent(new TaskComponent("Implement web services"));
        todo.addComponent(new TaskComponent("Implement unit tests"));
        todo.addComponent(new TaskComponent("Implement integration tests"));
        todo.addComponent(new TaskComponent("Write documentation"));
        layout.add(todo);

        todo.getDropTarget().addDropListener(event -> {
            event.getDragSourceComponent().ifPresent(component -> todo.addComponent((TaskComponent) component));
        });

        ongoing = new DropTargetPanel("Ongoing");

        layout.add(ongoing);
        ongoing.getDropTarget().addDropListener(event -> {
            event.getDragSourceComponent().ifPresent(component -> ongoing.addComponent((TaskComponent) component));
        });

        done = new DropTargetPanel("Done");
        done.getDropTarget().addDropListener(dropEvent -> {
           Optional<Component> source = dropEvent.getDragSourceComponent();
           source.ifPresent(component -> {
               if (!(component instanceof TaskComponent)) return;
               TaskComponent task = (TaskComponent) component;
               if (task.getParentPanel() != ongoing) return;
               done.addComponent(task);
           });
        });
        layout.add(done);
    }


}