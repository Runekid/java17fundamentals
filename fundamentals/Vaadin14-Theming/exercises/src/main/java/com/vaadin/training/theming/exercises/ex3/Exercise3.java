package com.vaadin.training.theming.exercises.ex3;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.training.theming.exercises.MainLayout;

import java.text.DateFormatSymbols;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Route(value = Exercise3.ROUTE, layout = MainLayout.class)
public class Exercise3 extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    public static final String ROUTE = "ex3";
    public static final String TITLE = "Exercise 3";

    private Grid<MonthlyExpense> expensesGrid;
    private TextField limit;

    public Exercise3() {
        setSizeFull();

        limit = createLimitTextField();
        add(limit);

        expensesGrid = new Grid<>();
        add(expensesGrid);
        expand(expensesGrid);

        initalizeAndPopulateGrid(expensesGrid);
    }

    private TextField createLimitTextField() {
        TextField limit = new TextField("Limit for monthly expenses");
        limit.addValueChangeListener(event -> {
            expensesGrid.getDataProvider().refreshAll();
        });
        return limit;
    }

    private void initalizeAndPopulateGrid(Grid<MonthlyExpense> grid) {
        grid.addColumn(MonthlyExpense::getMonth).setHeader("Month");
        //TODO replace expense column with a template render
        grid.addColumn(MonthlyExpense::getExpenses).setKey("expenses").setHeader("Expenses");
        grid.getColumnByKey("expenses").setClassNameGenerator(this::getClassName);

        List<MonthlyExpense> data = new ArrayList<>();
        for (int month = 0; month < 12; month++) {
            data.add(new MonthlyExpense(Month.values()[month].toString(), getExpenses(month)));
        }
        grid.setItems(data);
        grid.setHeightByRows(true);
    }

    private String getClassName(MonthlyExpense expense) {
        if (expense.getExpenses() > getMonthlyExpenseLimit()) {
            return "warn";
        }else {
            return null;
        }
    }

    private long getExpenses(int month) {
        return 300 + month * 50;
    }

    private int getMonthlyExpenseLimit() {
        if (limit.getValue() == null || limit.getValue().isEmpty()) {
            return 100000;
        }
        return Integer.parseInt((String) limit.getValue());
    }
}