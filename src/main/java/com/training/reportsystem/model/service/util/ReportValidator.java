package com.training.reportsystem.model.service.util;

import com.training.reportsystem.util.ValueParser;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.Parameters;
import com.training.reportsystem.util.constants.RegexConstants;
import com.training.reportsystem.util.i18n.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class ReportValidator implements Validator {

    private boolean isValid = true;

    public LocalDate inputPeriodFrom(HttpServletRequest request) {
        String periodFrom = request.getParameter(Parameters.PERIOD_FROM);
        if (periodFrom.isEmpty() || !periodFrom.matches(RegexConstants.DATE_REGEX)) {
            isValid = validationFailed(request, Attributes.PERIOD_FROM_ERROR, ErrorMessages.INCORRECT_DATE_FORMAT);
        }
        return LocalDate.parse(periodFrom);
    }

    public LocalDate inputPeriodTo(HttpServletRequest request) {
        String periodTo = request.getParameter(Parameters.PERIOD_TO);
        if (periodTo.isEmpty() || !periodTo.matches(RegexConstants.DATE_REGEX)) {
            isValid = validationFailed(request, Attributes.PERIOD_TO_ERROR, ErrorMessages.INCORRECT_DATE_FORMAT);
        }
        return LocalDate.parse(periodTo);
    }

    public Long inputRevenue(HttpServletRequest request) {
        String revenue = request.getParameter(Parameters.REVENUE);
        if (!revenue.matches(RegexConstants.MONEY)) {
            isValid = validationFailed(request, Attributes.REVENUE_ERROR, ErrorMessages.INCORRECT_REVENUE);
        }
        return ValueParser.parseRevenue(revenue);
    }

    public Double inputTax(HttpServletRequest request) {
        String tax = request.getParameter(Parameters.TAX);
        if (!tax.matches(RegexConstants.NUMBER)) {
            isValid = validationFailed(request, Attributes.TAX_ERROR, ErrorMessages.INCORRECT_TAX);
        }
        return ValueParser.parseTax(tax);
    }

    public String inputCommentary(HttpServletRequest request) {
        String commentary = request.getParameter(Parameters.COMMENTARY);
        if(commentary.isEmpty()){
            return null;
        }
        if (!commentary.matches(RegexConstants.COMMENTARY)) {
            isValid = validationFailed(request, Attributes.COMMENTARY_ERROR, ErrorMessages.INCORRECT_COMMENTARY);
        }
        return commentary;
    }


    private boolean validationFailed(HttpServletRequest request, String attributeName, String message) {
        request.getSession().setAttribute(attributeName, LocalisationUtil.getMessage(message));
        return false;
    }

    @Override
    public boolean isValid() {
        return isValid;
    }
}
