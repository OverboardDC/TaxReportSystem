package com.training.reportsystem.util;

import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalisationUtil {

    public static final Locale ENGLISH = new Locale("en", "US");

    public static final Locale RUSSIAN = new Locale("ru", "RU");

    private static final String BUNDLE_NAME = "messages";

    public static void setErrorMessage(String attribute, String message, HttpServletRequest request){
        request.getSession().setAttribute(attribute, getMessage(message, request.getSession()));
    }

    private static String getMessage(String key, HttpSession session) {
        Locale lang = (Locale) session.getAttribute(Parameters.LANG);
        ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME, lang);
        return bundle.getString(key);
    }
}
