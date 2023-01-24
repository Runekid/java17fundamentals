package com.vaadin.training.template.exercises.ex1;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.training.template.exercises.MainLayout;

@Tag("ex1-layout")
@JsModule("./src/ex1-layout.js")
@ParentLayout(MainLayout.class)
public class Exercise1Layout extends PolymerTemplate<TemplateModel> implements RouterLayout {

    //TODO: Declare a Div field (don't create an instance),
    // and give the Div field an @Id annotation to connect to the client side element
    @Id("content")
    private Div div;

    //TODO: override the showRouterLayoutContent method to add the incoming content to the new Div field.

    @Override
    public void showRouterLayoutContent(HasElement content) {
        div.getElement().appendChild(content.getElement());
    }
}
