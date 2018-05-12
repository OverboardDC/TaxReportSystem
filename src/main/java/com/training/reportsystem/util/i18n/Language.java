package com.training.reportsystem.util.i18n;

import java.util.Locale;

public class Language {

    private Locale locale;
    private String dateTimePattern;

    public Language(Locale locale, String dateTimePattern) {
        this.locale = locale;
        this.dateTimePattern = dateTimePattern;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getDateTimePattern() {
        return dateTimePattern;
    }

    public void setDateTimePattern(String dateTimePattern) {
        this.dateTimePattern = dateTimePattern;
    }
}
