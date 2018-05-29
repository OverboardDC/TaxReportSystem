package com.training.reportsystem.model.service.util;

import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.Parameters;
import com.training.reportsystem.util.constants.RegexConstants;
import com.training.reportsystem.util.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;

public class UserValidator implements Validator{

    private boolean isValid = true;

    public String inputUsername(HttpServletRequest request) {
        String value = request.getParameter(Parameters.USERNAME);
        if (!value.matches(RegexConstants.USERNAME_REGEX)) {
            isValid = validationFailed(request, Attributes.USERNAME_ERROR, ErrorMessages.INCORRECT_USERNAME);
        }
        return value;
    }

    public String inputPassword(HttpServletRequest request) {
        String value = request.getParameter(Parameters.PASSWORD);
        if (!value.matches(RegexConstants.PASSWORD_REGEX)) {
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
        if (!value.matches(RegexConstants.FIRST_NAME_REGEX)) {
            isValid = validationFailed(request, Attributes.FIRST_NAME_ERROR, ErrorMessages.INCORRECT_FIRST_NAME);
        }
        return value;
    }

    public String inputLastName(HttpServletRequest request) {
        String value = request.getParameter(Parameters.LAST_NAME);
        if (!value.matches(RegexConstants.LAST_NAME_REGEX)) {
            isValid = validationFailed(request, Attributes.LAST_NAME_ERROR, ErrorMessages.INCORRECT_LAST_NAME);
        }
        return value;
    }

    public String inputIdentificationCode(HttpServletRequest request) {
        String value = request.getParameter(Parameters.IDENTIFICATION_CODE);
        if (!value.matches(RegexConstants.IDENTIFICATION_CODE_REGEX)) {
            isValid = validationFailed(request, Attributes.IDENTIFICATION_CODE_ERROR, ErrorMessages.INCORRECT_IDENTIFICATION_CODE);
        }
        return value;
    }

    private boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        LocalisationUtil.setErrorMessage(attributeName, message, request);
        return false;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }
}

