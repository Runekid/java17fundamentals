package com.vaadin.training.layouting.exercises.ex2;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.training.layouting.exercises.MainLayout;


@Route(value = UseFormLayout.ROUTE, layout = MainLayout.class)
public class UseFormLayout extends VerticalLayout {
    public static final String ROUTE = "ex2";
    public static final String TITLE = "Exercise 2";

    public UseFormLayout(){
        setSizeFull();
        FormLayout formLayout = new FormLayout();

        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1,
                        FormLayout.ResponsiveStep.LabelsPosition.TOP),
                new FormLayout.ResponsiveStep("20em", 1),
                new FormLayout.ResponsiveStep("50em", 2));

        TextField firstName = new TextField();
        firstName.setWidthFull();
        formLayout.addFormItem(firstName,"First Name");

        TextField lastName = new TextField();
        lastName.setWidthFull();
        formLayout.addFormItem(lastName,"Last Name");

        TextField email = new TextField();
        email.setWidthFull();
        FormLayout.FormItem email1FormItem = formLayout.addFormItem(email,"Email");
        formLayout.setColspan(email1FormItem,2);

        FlexLayout phoneLayout = new FlexLayout();
        phoneLayout.setWidthFull();
        TextField phone = new TextField();
        Checkbox doNotCall = new Checkbox("Do not call");
        phoneLayout.add(phone,doNotCall);
        phoneLayout.expand(phone);
        phoneLayout.setAlignItems(Alignment.CENTER);
        FormLayout.FormItem phoneFormItem =formLayout.addFormItem(phoneLayout,"Phone");
        formLayout.setColspan(phoneFormItem,2);

        PasswordField password = new PasswordField();
        formLayout.addFormItem(password,"Password");

        formLayout.getElement().appendChild(ElementFactory.createBr());

        PasswordField repeatPwd = new PasswordField();
        formLayout.addFormItem(repeatPwd,"Repeat Password");






        add(formLayout);
    }
}
