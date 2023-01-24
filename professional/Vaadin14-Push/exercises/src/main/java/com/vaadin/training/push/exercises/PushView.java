package com.vaadin.training.push.exercises;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.push.exercises.backend.PersonService;
import com.vaadin.training.push.exercises.data.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Route
@RouteAlias(value = "")
@Push
public class PushView extends VerticalLayout {

    final Grid<Person> personGrid = new Grid<>();
    final Paragraph loadingText = new Paragraph("Loading");

    PersonService personService = new PersonService();

    public PushView() {
        setSizeFull();

        personGrid.addColumn(Person::getLastName).setHeader("Lastname");
        personGrid.addColumn(Person::getFirstName).setHeader("Firstname");
        personGrid.addColumn(Person::getEmail).setHeader("E-Mail");

        personGrid.setWidth("90%");

    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        super.onAttach(attachEvent);
        ExecutorService executor = Executors.newCachedThreadPool();
        showLoadingText();
        add(personGrid);
        // TODO fetch employees from the personService and show them in the
        // personGrid
        UI ui = getUI().get();
        CompletableFuture<List<Person>> future = CompletableFuture.supplyAsync(personService::getEmployees,executor);
        future.thenAccept(employees -> ui.access(() -> {
            personGrid.setItems(employees);
            hideLoadingText();
        }));
    }

    public void showLoadingText() {
        add(loadingText);
    }

    public void hideLoadingText() {
        remove(loadingText);
    }

}
