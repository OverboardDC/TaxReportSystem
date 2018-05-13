package com.training.reportsystem.util.i18n;

import java.util.Locale;

public class Language {

    private Locale locale;
    private String dateTimePattern;
    private String datePattern;

    public Language(Locale locale, String dateTimePattern, String datePattern) {
        this.locale = locale;
        this.dateTimePattern = dateTimePattern;
        this.datePattern = datePattern;
    }

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
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
