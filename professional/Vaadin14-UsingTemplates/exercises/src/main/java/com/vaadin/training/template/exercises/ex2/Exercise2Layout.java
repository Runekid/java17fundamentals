package com.vaadin.training.template.exercises.ex2;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.ParentLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.training.template.exercises.MainLayout;

@ParentLayout(MainLayout.class)
@Tag("ex2-layout")
@JsModule("./src/ex2-layout.js")
public class Exercise2Layout extends PolymerTemplate<TemplateModel> implements RouterLayout {

}
