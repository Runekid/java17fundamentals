package com.vaadin.training.dnd.solutions.ex1;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.dnd.solutions.MainLayout;

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
        add(layout);
        layout.setSizeFull();

        todo = new DropTargetPanel("TODO");
        todo.addComponent(new TaskComponent("Implement UI layer"));
        todo.addComponent(new TaskComponent("Implement web services"));
        todo.addComponent(new TaskComponent("Implement unit tests"));
        todo.addComponent(new TaskComponent("Implement integration tests"));
        todo.addComponent(new TaskComponent("Write documentation"));
        layout.add(todo);

        ongoing = new DropTargetPanel("Ongoing");
        layout.add(ongoing);

        done = new DropTargetPanel("Done");
        layout.add(done);

        DropTarget<?> todoDropTarget = todo.getDropTarget();
        todoDropTarget.addDropListener(dropEvent -> {
            Optional<Component> dragSourceComponent = dropEvent.getDragSourceComponent();
            dragSourceComponent.ifPresent(component -> todo.addComponent(component));
        });

        DropTarget<?> ongoingDropTarget = ongoing.getDropTarget();
        ongoingDropTarget.addDropListener(dropEvent -> {
            Optional<Component> dragSourceComponent = dropEvent.getDragSourceComponent();
            dragSourceComponent.ifPresent(component -> ongoing.addComponent(component));
        });

        DropTarget<?> doneDropTarget = done.getDropTarget();
        doneDropTarget.addDropListener(dropEvent -> {
            Optional<Component> dragSource = dropEvent.getDragSourceComponent();
            dragSource.ifPresent(component -> {
                if (!(component instanceof TaskComponent)) {
                    return;
                }
                TaskComponent task = (TaskComponent) component;
                final DropTargetPanel parentPanel = task.getParentPanel();
                if (parentPanel != ongoing) {
                    return;
                }
                done.addComponent(task);
            });
        });

    }


}