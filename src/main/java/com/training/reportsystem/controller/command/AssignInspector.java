package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;
import com.training.reportsystem.util.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class AssignInspector implements Command{

    private TaxPayerService taxPayerService;

    public AssignInspector(TaxPayerService taxPayerService) {
        this.taxPayerService = taxPayerService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long taxPayerId = Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID));
        Optional<String> inspectorId = Optional.ofNullable(request.getParameter(Parameters.INSPECTOR_ID));
        if(!inspectorId.isPresent()){
            LocalisationUtil.setErrorMessage(Attributes.ADMIN_PAGE_ERROR, ErrorMessages.INSPECTOR_WASNT_CHOSEN, request);
            return Pages.ADMIN_REDIRECT;
        }
        taxPayerService.assignInspector(taxPayerId, Long.valueOf(inspectorId.get()));
        logger.info(LoggerUtil.formMessage(LoggerMessages.INSPECTOR_ASSIGNED));
        return Pages.ADMIN_REDIRECT;
    }
}
