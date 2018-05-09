package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxPayerPage implements Command {

    private InspectorService inspectorService;

    public TaxPayerPage(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        request.setAttribute(Attributes.INSPECTOR, inspectorService.getByUserId(taxPayer.getId()));
        return Pages.TAX_PAYER;
    }
}
