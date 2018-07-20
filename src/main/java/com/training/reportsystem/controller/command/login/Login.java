package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.controller.config.ApplicationConfig;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.UserService;
import com.training.reportsystem.model.service.impl.hibernate.UserServiceHibernate;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;
import com.training.reportsystem.util.i18n.LocalisationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static com.training.reportsystem.util.constants.LoggerMessages.INVALID_DATA;
import static com.training.reportsystem.util.constants.LoggerMessages.LOGIN_FAILED;
import static com.training.reportsystem.util.constants.LoggerMessages.REASON;

@Controller
public class Login implements Command {

    private UserService userService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter(Parameters.USERNAME);
        String password = request.getParameter(Parameters.PASSWORD);
        Optional<User> user = Optional.ofNullable(userService.login(username, password));
        if (user.isPresent()) {
            return LoginUtil.authorizeUser(user.get(), request);
        }
        request.getSession().setAttribute(Attributes.LOGIN_ERROR, LocalisationUtil.getMessage(ErrorMessages.LOGIN_ERROR));
        logger.info(LoggerUtil.formMessage(LOGIN_FAILED, username, REASON, INVALID_DATA));
        return Pages.LOGIN_REDIRECT;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}

