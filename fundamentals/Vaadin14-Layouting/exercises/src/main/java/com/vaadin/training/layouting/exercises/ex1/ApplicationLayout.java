package com.vaadin.training.layouting.exercises.ex1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import com.vaadin.training.layouting.exercises.MainLayout;

@Route(value = ApplicationLayout.ROUTE, layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class ApplicationLayout extends VerticalLayout implements HasUrlParameter<String> {

	private static final long serialVersionUID = 1L;

	public static final String ROUTE = "ex1";
	public static final String TITLE = "Exercise 1";

	private final HorizontalLayout horizontalLayout;
	private Div navigation;
	private Div content;

	public ApplicationLayout() {
		setSizeFull();
		setPadding(false);
		setSpacing(false);
		setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

		final Div header = new Div();
		header.setText("This is the header. My height is 150 pixels");
		header.setClassName("header");
		header.setWidthFull();
		header.setHeight("150px");
		header.getStyle().set("flex-shrink","0");

		navigation = new Div();
		navigation.setClassName("navigation");
		navigation.setText("This is the navigation area. My width is 25% of the ApplicationLayout.");
		navigation.setWidth("25%");
		navigation.getStyle().set("flex-shrink","0");


		content = new Div();
		content.setClassName("content");
		content.setText("This is the content area");
		content.setHeightFull();
		content.getStyle().set("display","flex");
		content.getStyle().set("alignContent","start");

		horizontalLayout = new HorizontalLayout();
		horizontalLayout.setFlexGrow(1);
		horizontalLayout.setHeightFull();
		horizontalLayout.setSpacing(false);
		horizontalLayout.add(navigation,content);
		horizontalLayout.expand(content);
		horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.STRETCH);

		final Div footer = new Div();
		footer.setText("This is the footer area. My height is 100 pixels");
		footer.setClassName("footer");
		footer.setWidthFull();
		footer.setHeight("100px");
		footer.getStyle().set("flex-shrink","0");


		add(header, horizontalLayout, footer);
		expand(horizontalLayout);
	}

	/**
	 * Ignore this method for now.
	 *
	 * @return
	 */
	private Div createBlock() {
		final Div button = new Div();
		button.setText("Block");
		button.getStyle().set("background", "white");
		button.setHeight("100px");
		button.setWidth("100px");
		button.getStyle().set("margin", "2px");
		return button;
	}


	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
		if ("scroll".equals(parameter)) {
			updateUIForScroll();
		}
	}

	private void updateUIForScroll() {
		final Button add = new Button("Add", e -> {
			content.add(createBlock());
		});
		navigation.setText(null);
		content.setText(null);

		navigation.add(add);

		makeContentScrollable();

	}

	private void makeContentScrollable() {
		content.getStyle().set("flexWrap", "wrap");
		content.getStyle().set("overflowY", "auto");
	}
}