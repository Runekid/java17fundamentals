package com.vaadin.samples.flow;


import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.samples.about.flow.AboutView;
import com.vaadin.samples.authentication.AccessControlFactory;
import com.vaadin.samples.crud.flow.SampleCrudView;

/**
 * Content of the UI when the user is logged in.
 * 
 * 
 */
public class MainLayout extends HorizontalLayout implements RouterLayout, BeforeEnterObserver {
    private Menu menu;
    private final FlexLayout viewContainer;

    public MainLayout() {

        setSpacing(false);
        setClassName("main-screen");

        viewContainer = new FlexLayout();
        viewContainer.addClassName("valo-content");
        viewContainer.setSizeFull();

        menu = new Menu();
        menu.addView(SampleCrudView.class, SampleCrudView.VIEW_NAME,
                VaadinIcon.EDIT.create());
        menu.addView(AboutView.class, AboutView.VIEW_NAME,
                VaadinIcon.INFO_CIRCLE.create());

        add(menu, viewContainer);
        expand(viewContainer);
        setDefaultVerticalComponentAlignment(Alignment.STRETCH);
        setSizeFull();
    }

    @Override
    public void showRouterLayoutContent(HasElement content) {
        viewContainer.getElement().appendChild(content.getElement());
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (!AccessControlFactory.getAccessControl().isUserSignedIn()) {
            event.rerouteTo("login");
        }
    }
}
