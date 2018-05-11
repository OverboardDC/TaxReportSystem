package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.LoggerMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

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
        inspectorId.ifPresent(s -> taxPayerService.assignInspector(taxPayerId, Long.valueOf(s)));
        logger.info(LoggerUtil.formMessage(LoggerMessages.INSPECTOR_ASSIGNED));
        return Pages.ADMIN_REDIRECT;
    }
}
