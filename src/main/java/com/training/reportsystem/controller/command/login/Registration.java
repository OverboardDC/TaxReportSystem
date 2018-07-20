package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Role;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.UserService;
import com.training.reportsystem.model.service.util.UserValidator;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.Md5Encryptor;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.i18n.LocalisationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.training.reportsystem.util.constants.LoggerMessages.*;

@Controller
public class Registration implements Command {

    private TaxPayerService taxPayerService;
    private UserService userService;

        @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserValidator validator = new UserValidator();
        String username = validator.inputUsername(request);
        String password = validator.inputPassword(request);
        validator.inputRepeatPassword(request, password);
        String firstName = validator.inputFirsName(request);
        String lastName = validator.inputLastName(request);
        String identificationCode = validator.inputIdentificationCode(request);

        if (!validator.isValid()) {
            logger.info(LoggerUtil.formMessage(REGISTRATION_FAILED, REASON, INVALID_DATA));
            return Pages.REGISTRATION_REDIRECT;
        }

        if(!userService.isUsernameUnique(username)){
            logger.info(LoggerUtil.formMessage(REGISTRATION_FAILED, REASON, DUPLICATED_USERNAME));
            request.getSession().setAttribute(Attributes.USERNAME_ERROR, LocalisationUtil.getMessage(ErrorMessages.USERNAME_ALREADY_EXITS));
            return Pages.REGISTRATION_REDIRECT;
        }

        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().setUsername(username).setPassword(Md5Encryptor.encrypt(password))
                .setFirstName(firstName).setLastName(lastName).setIdentificationCode(identificationCode)
                .setRole(Role.CLIENT).build();
        taxPayerService.create(taxPayer);
        logger.info(LoggerUtil.formMessage(REGISTRATION_SUCCESS, USER, taxPayer.getUsername()));
        return Pages.LOGIN_REDIRECT;
    }

    @Autowired
    public void setTaxPayerService(TaxPayerService taxPayerService) {
        this.taxPayerService = taxPayerService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
