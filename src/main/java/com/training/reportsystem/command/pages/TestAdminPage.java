package com.training.reportsystem.command.pages;

import com.training.reportsystem.command.Command;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO Temporary
public class TestAdminPage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Pages.TEST_ADMIN;
    }
}
