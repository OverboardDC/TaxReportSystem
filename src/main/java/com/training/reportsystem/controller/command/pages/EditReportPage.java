package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class EditReportPage implements Command {

    private ReportService reportService;
    private InspectorService inspectorService;


    public EditReportPage(ReportService reportService, InspectorService inspectorService) {
        this.reportService = reportService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Report report = reportService.getById(Long.valueOf(request.getParameter(Parameters.REPORT_ID)));
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        Optional<Inspector> inspector = Optional.of(inspectorService.getByUserId(taxPayer.getId()));
        request.setAttribute(Attributes.INSPECTOR, inspector);
        request.setAttribute(Attributes.REPORT, report);
        return Pages.EDIT_REPORT;
    }
}
