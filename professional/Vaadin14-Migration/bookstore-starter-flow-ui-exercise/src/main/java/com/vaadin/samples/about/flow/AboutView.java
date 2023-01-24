package com.vaadin.samples.about.flow;


import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.Version;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.samples.flow.MainLayout;

@Route(value=AboutView.VIEW_NAME,layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    public static final String VIEW_NAME = "About";

    public AboutView() {
        Div aboutContent = new Div();
        aboutContent.addClassName("about-content");

        // you can add Vaadin components in predefined slots in the custom
        // layout
        aboutContent.add(
                new Html("<div>" + VaadinIcons.INFO_CIRCLE.getHtml()
                        + " This application is using Vaadin "
                        + Version.getFullVersion() + "</div>"));

        setSizeFull();
        setMargin(false);
        addClassName("about-view");
        add(aboutContent);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

}
