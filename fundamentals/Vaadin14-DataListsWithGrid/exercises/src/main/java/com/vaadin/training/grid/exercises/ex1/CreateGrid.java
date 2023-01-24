package com.vaadin.training.grid.exercises.ex1;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.grid.exercises.MainLayout;

import java.util.List;

@Route(value = CreateGrid.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class CreateGrid extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "Exercise 1";
	public static final String ROUTE = "ex1";

	final PersonService service = new PersonService();

	public CreateGrid() {
		setWidth("100%");

		final List<Person> persons = service.getAllPersons();

		// TODO create a Grid
		final Grid<Person> grid = new Grid<>(Person.class);
		grid.setWidth("90%");
		grid.setColumnOrder(grid.getColumnByKey("name"),
				grid.getColumnByKey("email"),
				grid.getColumnByKey("age"),
				grid.getColumnByKey("birthday")
				);
		grid.removeColumn(grid.getColumnByKey("birthday"));
		grid.addColumn(new LocalDateRenderer<Person>(Person::getBirthday)).setHeader("Birthday");


		// TODO create a DataProvider for the Grid
		grid.setItems(persons);
		add(grid);
	}

}
