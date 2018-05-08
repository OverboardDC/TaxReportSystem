package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.LocalisationUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

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
        return Pages.ALL_REQUESTS_REDIRECT;
    }
}
