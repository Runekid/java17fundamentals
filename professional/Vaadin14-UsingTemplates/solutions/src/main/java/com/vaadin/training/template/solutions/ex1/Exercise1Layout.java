package com.vaadin.training.template.solutions.ex1;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.training.template.solutions.MainLayout;

@Tag("ex1-layout")
@JsModule("./src/ex1-layout.js")
@ParentLayout(MainLayout.class)
public class Exercise1Layout extends PolymerTemplate<TemplateModel> implements RouterLayout {

    @Id("contentArea")
    private Div contentArea;

    @Override
    public void showRouterLayoutContent(HasElement content) {
        contentArea.getElement().appendChild(content.getElement());
    }
}
