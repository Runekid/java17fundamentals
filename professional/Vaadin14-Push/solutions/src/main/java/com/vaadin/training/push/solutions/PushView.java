package com.vaadin.training.push.solutions;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.push.solutions.backend.PersonService;
import com.vaadin.training.push.solutions.data.Person;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Route
@RouteAlias(value = "")
@Push
public class PushView extends VerticalLayout{

    final Grid<Person> personGrid = new Grid<>();

    final Paragraph loadingText = new Paragraph("loading...");

    PersonService personService = new PersonService();

    final ExecutorService executor = Executors.newCachedThreadPool();

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

        add(loadingText, personGrid);

        final CompletableFuture<List<Person>> future = CompletableFuture.supplyAsync(personService::getEmployees,
                executor);

        // Whenever the call is done...
        future.thenAccept(personList -> {
            // this happens outside of a normal request, so we need access()
            attachEvent.getUI().access(() -> {
                personGrid.setItems(personList);
                loadingText.setVisible(false);
            });
        });
    }

}
