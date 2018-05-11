package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.LocalisationUtil;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Optional;

import static com.training.reportsystem.util.constants.LoggerMessages.*;


public class Login implements Command {

    private TaxPayerService taxPayerService;
    private InspectorService inspectorService;

    public Login(TaxPayerService taxPayerService, InspectorService inspectorService) {
        this.taxPayerService = taxPayerService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter(Parameters.USERNAME);
        String password = request.getParameter(Parameters.PASSWORD);
        String userType = request.getParameter(Parameters.USER_TYPE);
        Optional<User> user = getUser(username, password, userType);
        System.out.println("User: " + user);
        if (user.isPresent()) {
            return LoginUtil.authorizeUser(user.get(), request);
        }
        request.getSession().setAttribute(Attributes.LOGIN_ERROR, LocalisationUtil.getMessage(ErrorMessages.LOGIN_ERROR));
        logger.info(LoggerUtil.formMessage(LOGIN_FAILED, username));
        return Pages.LOGIN_REDIRECT;
    }

    private Optional<User> getUser(String username, String password, String userType) {
        Optional<User> user;
        if (userType.equals(Parameters.CLIENT)) {
            user = Optional.ofNullable(taxPayerService.login(username, password));
        } else {
            user = Optional.ofNullable(inspectorService.login(username, password));
        }
        return user;
    }


}

