package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewReportPage implements Command {

    private InspectorService inspectorService;

    public NewReportPage(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        Inspector inspector = inspectorService.getByUserId(taxPayer.getId());
        request.setAttribute(Attributes.INSPECTOR, inspector);
        return Pages.NEW_REPORT;
    }
}
