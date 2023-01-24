package com.vaadin.training.i18n.exercises;

import com.vaadin.flow.i18n.I18NProvider;

import java.text.MessageFormat;
import java.util.*;

public class TranslationProvider implements I18NProvider {

    public static final String BUNDLE_PREFIX = "test";

    @Override
    public List<Locale> getProvidedLocales() {
        //to read a bundle
        return Collections
                .unmodifiableList(Arrays.asList(new Locale("en"), new Locale("fi")));
    }

    @Override
    public String getTranslation(String key, Locale locale, Object... params) {
        final ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_PREFIX, locale);

        String value= bundle.getString(key);
        if (params.length > 0) {
            value = MessageFormat.format(value, params);
        }
        return value;
    }
}
