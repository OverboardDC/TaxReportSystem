package com.training.reportsystem.command.login;

import com.training.reportsystem.command.Command;
import com.training.reportsystem.entity.user.TaxPayer;
import com.training.reportsystem.entity.user.User;
import com.training.reportsystem.service.UserService;
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
            setUserAttribute(request, user.get());
            return Pages.INDEX_REDIRECT;
        }
        request.getSession().setAttribute(Attributes.LOGIN_ERROR, LocalisationUtil.getMessage(ErrorMessages.LOGIN_ERROR));
        return Pages.LOGIN_REDIRECT;
    }

    private void setUserAttribute(HttpServletRequest request, User user) {
        if (user instanceof TaxPayer) {
            request.getSession().setAttribute(Attributes.CLIENT, user);
        } else {
            request.getSession().setAttribute(Attributes.INSPECTOR, user);
        }
    }
}

