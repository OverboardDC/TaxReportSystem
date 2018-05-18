package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.LoggerMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveReport implements Command {

    private ReportService reportService;

    public ApproveReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long reportId = Long.valueOf(request.getParameter(Parameters.REPORT_ID));
        reportService.approveReport(reportId);
        logger.info(LoggerUtil.formMessage(LoggerMessages.REPORT_WAS_APPROVED));
        return Pages.INSPECTOR_REDIRECT;
    }
}
