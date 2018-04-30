package com.training.reportsystem.command.pages;

import com.training.reportsystem.command.Command;
import com.training.reportsystem.util.constants.AttributeConstants;
import com.training.reportsystem.util.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationPage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute(AttributeConstants.PAGE, PageConstants.REGISTRATION);
        return PageConstants.REGISTRATION;
    }
}
