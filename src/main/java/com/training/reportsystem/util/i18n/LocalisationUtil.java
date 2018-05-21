package com.training.reportsystem.util.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalisationUtil {

    public static final Language ENGLISH = new Language(new Locale("en", "US"),
            "MM-dd-yyyy HH:mm", "MM-dd-yyyy");
    public static final Language RUSSIAN = new Language(new Locale("ru", "RU"),
            "dd-MM-yyyy HH:mm", "dd-MM-yyyy");
    private static final String BUNDLE_NAME = "messages";

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, ENGLISH.getLocale());

    private static Language currentLanguage = ENGLISH;

    public static void setLocale(Language language) {
        resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, language.getLocale());
        currentLanguage = language;
    }

    public static Language getCurrentLanguage() {
        return currentLanguage;
    }

    public static String getMessage(String key) {
        return resourceBundle.getString(key);
    }
}
