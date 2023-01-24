package com.vaadin.training.i18n.exercises;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

import java.util.Locale;

@Route("")
public class MainView extends VerticalLayout implements LocaleChangeObserver {
    private final Button button = new Button();

    public MainView() {
        button.setText("Click me");
        button.addClickListener(event -> Notification.show("clicked"));


        ComboBox<Locale> localeComboBox = new ComboBox<>();
        localeComboBox.setItems(Locale.ENGLISH, new Locale("fi"));
        localeComboBox.setValue(Locale.ENGLISH);
        localeComboBox.addValueChangeListener(event ->{
            //change the locale in the VaadinSession
            VaadinSession.getCurrent().setLocale(event.getValue());
        });

        add(localeComboBox, button);
    }

    @Override
    public void localeChange(LocaleChangeEvent localeChangeEvent) {
        button.setText(getTranslation("btn.key"));
        button.addClickListener(event -> Notification.show(getTranslation("clicked")));
    }
}