package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.util.constants.Pages;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomePage implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Pages.INDEX;
    }
}
