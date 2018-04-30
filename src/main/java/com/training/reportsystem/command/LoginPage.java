package com.training.reportsystem.command;

import com.training.reportsystem.util.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageConstants.LOGIN;
    }
}
