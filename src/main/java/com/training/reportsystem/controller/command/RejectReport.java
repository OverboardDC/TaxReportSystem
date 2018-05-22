package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.util.constants.*;
import com.training.reportsystem.util.i18n.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RejectReport implements Command {

    private ReportService reportService;

    public RejectReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long reportId = Long.valueOf(request.getParameter(Parameters.REPORT_ID));
        String rejectReason = request.getParameter(Parameters.REJECT_REASON);
        if(!rejectReason.matches(RegexConstants.MESSAGE)){
            request.getSession().setAttribute(Attributes.INSPECTOR_PAGE_ERROR, LocalisationUtil.getMessage(ErrorMessages.INCORRECT_REASON));
            return Pages.INSPECTOR_REDIRECT;
        }
        reportService.rejectReport(reportId, rejectReason);
        return Pages.INSPECTOR_REDIRECT;
    }
}
