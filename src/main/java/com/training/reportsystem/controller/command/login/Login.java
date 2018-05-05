package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.user.User;
import com.training.reportsystem.model.service.UserService;
import com.training.reportsystem.util.LocalisationUtil;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class Login implements Command {

    private UserService userService;

    public Login(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter(Parameters.USERNAME);
        String password = request.getParameter(Parameters.PASSWORD);
        Optional<User> user = Optional.ofNullable(userService.login(username, password));
        if (user.isPresent()) {
            LoginUtil.logout(request);
            request.getSession().setAttribute(Attributes.USER, user.get());
            return Pages.INDEX_REDIRECT;
        }
        request.getSession().setAttribute(Attributes.LOGIN_ERROR, LocalisationUtil.getMessage(ErrorMessages.LOGIN_ERROR));
        return Pages.LOGIN_REDIRECT;
    }
}

