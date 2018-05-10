package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxPayerPage implements Command {

    private InspectorService inspectorService;
    private ReportService reportService;

    public TaxPayerPage(InspectorService inspectorService, ReportService reportService) {
        this.inspectorService = inspectorService;
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        request.setAttribute(Attributes.INSPECTOR, inspectorService.getByUserId(taxPayer.getId()));
        request.setAttribute(Attributes.REPORTS, reportService.findAllByUser(taxPayer.getId()));
        return Pages.TAX_PAYER;
    }
}
