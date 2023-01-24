package com.vaadin.training.grid.exercises.ex2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.data.renderer.NumberRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.training.grid.exercises.MainLayout;
import com.vaadin.training.grid.exercises.ex1.Person;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;

@SuppressWarnings("serial")
@Route(value = FilteringDataProvider.ROUTE, layout = MainLayout.class)
public class FilteringDataProvider extends Composite<VerticalLayout> {

    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    private final ListDataProvider<Product> dataProvider;

    public FilteringDataProvider() {
        final VerticalLayout layout = getContent();
        layout.setWidth("100%");

        dataProvider = DataProviderHelper.createProductDataProvider();

        // TODO create layout for DateFields
        HorizontalLayout datefilterLayout = new HorizontalLayout();
        datefilterLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.END);
        DatePicker start = new DatePicker("Start");
        DatePicker end = new DatePicker("End");
        Button filter = new Button("Filter", buttonClickEvent -> {
            dataProvider.setFilter(product -> filterProduct(product, start.getValue(), end.getValue()));
        });
        datefilterLayout.add(start,end,filter);
        // TODO create and populate Grid
        Grid<Product> grid = new Grid<>();
        grid.addColumn(new LocalDateRenderer<>(Product::getAvailable)).setHeader("Available");
        grid.addColumn(Product::getName).setHeader("Name");
        grid.addColumn(new NumberRenderer<>(Product::getPrice, NumberFormat.getCurrencyInstance())).setHeader("Price");
        grid.setDataProvider(dataProvider);
        layout.add(datefilterLayout,grid);

    }

    private boolean filterProduct(Product product, LocalDate start, LocalDate end) {

        // TODO implement filtering logic here.
        if (product.getAvailable() == null) {
            if (start != null || end != null) return false;
            return true;
        }
        if (start == null && end == null) {
            return true;
        }
        if (start == null) {
            return product.getAvailable().isBefore(end.plusDays(1));
        }
        if (end == null) {
            return product.getAvailable().isAfter(start.minusDays(1)) || product.getAvailable().isEqual(start);
        }
        return product.getAvailable().isAfter(start.minusDays(1)) && product.getAvailable().isBefore(end.plusDays(1));
    }

}
