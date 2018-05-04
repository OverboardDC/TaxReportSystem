package com.training.reportsystem.command.login;

import com.training.reportsystem.command.Command;
import com.training.reportsystem.entity.user.Company;
import com.training.reportsystem.entity.user.Individual;
import com.training.reportsystem.entity.user.TaxPayer;
import com.training.reportsystem.service.UserService;
import com.training.reportsystem.service.util.UserValidator;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.UserType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO
public class Registration implements Command {

    private UserService userService;

    public Registration(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        UserValidator validator = new UserValidator();
        String clientType = validator.inputClientType(request);
        if (!validator.isValid()) {
            return Pages.REGISTRATION_REDIRECT;
        }
        String username = validator.inputUsername(request);
        String password = validator.inputPassword(request);
        validator.inputRepeatPassword(request, password);

        TaxPayer taxPayer;
        String lastClientType;
        if (clientType.equals(UserType.INDIVIDUAL)) {
            lastClientType = UserType.INDIVIDUAL;
            taxPayer = createIndividual(request, validator).setUsername(username).setPassword(password).build();
        } else {
            lastClientType = UserType.COMPANY;
            taxPayer = createCompany(request, validator).setUsername(username).setPassword(password).build();
        }
        if (!validator.isValid()) {
            request.getSession().setAttribute(Attributes.LAST_CLIENT_TYPE, lastClientType);
            return Pages.REGISTRATION_REDIRECT;
        }
        userService.create(taxPayer);


        return Pages.LOGIN_REDIRECT;
    }

    private Individual.IndividualBuilder createIndividual(HttpServletRequest request, UserValidator validator) {
        String firstName = validator.inputFirsName(request);
        String lastName = validator.inputLastName(request);
        String identificationCode = validator.inputIdentificationCode(request);
        return new Individual.IndividualBuilder().setId(1L).setFirstName(firstName).setLastName(lastName).
                setIdentificationCode(identificationCode);
    }

    private Company.CompanyBuilder createCompany(HttpServletRequest request, UserValidator validator) {
        String name = validator.inputName(request);
        return new Company.CompanyBuilder().setId(1L).setName(name);
    }

}
