package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.i18n.LocalisationUtil;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AcceptRequest implements Command{

    private RequestService requestService;
    private TaxPayerService taxPayerService;

    public AcceptRequest(RequestService requestService, TaxPayerService taxPayerService) {
        this.requestService = requestService;
        this.taxPayerService = taxPayerService;
    }

    @Override
    //TODO ?
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<String> inspectorId = Optional.ofNullable(request.getParameter(Parameters.INSPECTOR_ID));
        Long requestId = Long.valueOf(request.getParameter(Parameters.REQUEST_ID));
        if(!inspectorId.isPresent()){
            request.getSession().setAttribute(Attributes.INSPECTOR_ERROR, LocalisationUtil.getMessage(ErrorMessages.INCORRECT_INSPECTOR));
            return Pages.ALL_REQUESTS_REDIRECT;
        }

        Long taxPayerId = Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID));
        requestService.accept(requestId);
        taxPayerService.assignInspector(taxPayerId, Long.valueOf(inspectorId.get()));
        logger.info(LoggerUtil.formMessage(LoggerMessages.REQUEST_ACCEPTED));
        return Pages.ALL_REQUESTS_REDIRECT;
    }
}
