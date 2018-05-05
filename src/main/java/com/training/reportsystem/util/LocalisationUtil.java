package com.training.reportsystem.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalisationUtil {

    public static final Locale ENGLISH = new Locale("en", "US");
    public static final Locale RUSSIAN = new Locale("ru", "RU");
    private static final String BUNDLE_NAME = "/messages";

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, ENGLISH);

    public static void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
    }

    public static String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
