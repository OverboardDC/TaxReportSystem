package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;
import com.training.reportsystem.util.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AcceptRequest implements Command{

    private RequestService requestService;

    public AcceptRequest(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Optional<String> inspectorId = Optional.ofNullable(request.getParameter(Parameters.INSPECTOR_ID));
        Long requestId = Long.valueOf(request.getParameter(Parameters.REQUEST_ID));
        if(!inspectorId.isPresent()){
            LocalisationUtil.setErrorMessage(Attributes.ALL_REQUESTS_PAGE_ERROR, ErrorMessages.INSPECTOR_WASNT_CHOSEN, request);
            return Pages.ALL_REQUESTS_REDIRECT;
        }

        Long taxPayerId = Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID));
        requestService.accept(requestId, taxPayerId, Long.valueOf(inspectorId.get()));
        logger.info(LoggerUtil.formMessage(LoggerMessages.REQUEST_ACCEPTED));
        return Pages.ALL_REQUESTS_REDIRECT;
    }
}
