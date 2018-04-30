package com.training.reportsystem.command;

import com.training.reportsystem.util.LocalisationUtil;
import com.training.reportsystem.util.constants.AttributeConstants;
import com.training.reportsystem.util.constants.ParameterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter(ParameterConstants.LANG);
        if (lang.equals(ParameterConstants.EN)) {
            request.getSession().setAttribute(ParameterConstants.LANG, ParameterConstants.EN);
            LocalisationUtil.setLocale(LocalisationUtil.ENGLISH);
        } else {
            request.getSession().setAttribute(ParameterConstants.LANG, ParameterConstants.RU);
            LocalisationUtil.setLocale(LocalisationUtil.RUSSIAN);
        }
        return String.valueOf(request.getSession().getAttribute(AttributeConstants.PAGE));
    }
}
