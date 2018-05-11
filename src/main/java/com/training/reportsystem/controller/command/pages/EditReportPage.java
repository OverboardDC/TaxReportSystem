package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditReportPage implements Command {

    private ReportService reportService;

    public EditReportPage(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Report report = reportService.getById(Long.valueOf(request.getParameter(Parameters.REPORT_ID)));
        request.setAttribute(Attributes.REPORT, report);
        return Pages.EDIT_REPORT;
    }
}
