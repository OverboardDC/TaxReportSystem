package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LoginUtil.logout(request.getSession());
        return Pages.LOGIN;
    }
}
