package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.user.TaxPayer;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.util.UserValidator;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration implements Command {

    private TaxPayerService taxPayerService;

    public Registration(TaxPayerService taxPayerService) {
        this.taxPayerService = taxPayerService;
    }

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
            return Pages.REGISTRATION_REDIRECT;
        }

        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().setUsername(username).setPassword(password)
                .setFirstName(firstName).setLastName(lastName).setIdentificationCode(identificationCode).build();
        taxPayerService.create(taxPayer);
        return Pages.LOGIN_REDIRECT;
    }
}
