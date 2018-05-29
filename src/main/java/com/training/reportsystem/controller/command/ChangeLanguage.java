package com.training.reportsystem.controller.command;

import com.training.reportsystem.util.constants.GlobalConstants;
import com.training.reportsystem.util.constants.Parameters;
import com.training.reportsystem.util.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter(Parameters.LANG);
        if (lang.equals(Parameters.EN)) {
            request.getSession().setAttribute(Parameters.LANG, LocalisationUtil.ENGLISH);
        } else {
            request.getSession().setAttribute(Parameters.LANG, LocalisationUtil.RUSSIAN);
        }
        return request.getHeader(GlobalConstants.REFERER_HEADER);
    }
}
