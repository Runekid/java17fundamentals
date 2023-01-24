package com.vaadin.training.elements.exercises.exercise1;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.training.elements.exercises.MainLayout;
import java.text.DecimalFormat;

@PageTitle(Exercise1View.TITLE)
@Route(value = Exercise1View.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class Exercise1View extends Composite<VerticalLayout> implements HasComponents, HasStyle, HasSize {

    public static final String TITLE = "Exercise 1";
    public static final String ROUTE = "ex1";

    public Exercise1View() {
        setSizeFull();
        getContent().setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);

        Div orderEditorWrapper = new Div();
        // allow vertical overflowing - this style applies a vertical scrollbar when there
        // are so many items that they won't all fit the screen at once
        orderEditorWrapper.getStyle().set("overflow-y", "auto");
        add(orderEditorWrapper);
        getContent().setFlexGrow(1, orderEditorWrapper);

        OrderEditor orderEditor = new OrderEditor();
        orderEditorWrapper.add(orderEditor);

        Div totalPrice = new Div();
        // TODO: get the Style object of the totalPrice and add some style to make it more visible
        totalPrice.getStyle().set("color","red");

        DecimalFormat decimalFormat = new DecimalFormat("#0.00€");
        totalPrice.setText(decimalFormat.format(orderEditor.getTotalPrice()));
        add(totalPrice);

        orderEditor.addOrderChangeEventListener(event ->
                totalPrice.setText(decimalFormat.format(orderEditor.getTotalPrice())));
    }
}
