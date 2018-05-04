package com.training.reportsystem.service.util;

import com.training.reportsystem.util.LocalisationUtil;
import com.training.reportsystem.util.constants.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class UserValidator {

    private boolean isValid = true;

    public String inputClientType(HttpServletRequest request) {
        String value = request.getParameter(Parameters.CLIENT_TYPE);
        if (value == null || !value.equals(UserType.INDIVIDUAL) && !value.equals(UserType.COMPANY)) {
            isValid = validationFailed(request, Attributes.CLIENT_TYPE_ERROR, ErrorMessages.INCORRECT_INPUT);
        }
        return value;
    }

    public String inputUsername(HttpServletRequest request) {
        String value = request.getParameter(Parameters.USERNAME);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.USERNAME_ERROR, ErrorMessages.INCORRECT_USERNAME);
        }
        return value;
    }

    public String inputPassword(HttpServletRequest request) {
        String value = request.getParameter(Parameters.PASSWORD);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.PASSWORD_ERROR, ErrorMessages.INCORRECT_PASSWORD);
        }
        return value;
    }

    public void inputRepeatPassword(HttpServletRequest request, String password) {
        String value = request.getParameter(Parameters.PASSWORD_REPEAT);
        if (!value.equals(password)) {
            isValid = validationFailed(request, Attributes.PASSWORD_REPEAT_ERROR, ErrorMessages.PASSWORDS_DONT_MATCH);
        }
    }

    public String inputFirsName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.FIRST_NAME);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.FIRST_NAME_ERROR, ErrorMessages.INCORRECT_FIRST_NAME);
        }
        return value;
    }

    public String inputLastName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.LAST_NAME);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.LAST_NAME_ERROR, ErrorMessages.INCORRECT_LAST_NAME);
        }
        return value;
    }

    public String inputIdentificationCode(HttpServletRequest request) {
        String value = request.getParameter(Parameters.IDENTIFICATION_CODE);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.IDENTIFICATION_CODE_ERROR, ErrorMessages.INCORRECT_IDENTIFICATION_CODE);
        }
        return value;
    }

    public String inputName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.NAME);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.NAME_ERROR, ErrorMessages.INCORRECT_NAME);
        }
        return value;
    }

    private boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        request.getSession().setAttribute(attributeName, LocalisationUtil.getMessage(message));
        return false;
    }

    public boolean isValid() {
        return isValid;
    }
}

