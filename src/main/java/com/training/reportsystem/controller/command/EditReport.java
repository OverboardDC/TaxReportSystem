package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.ReportValidator;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class EditReport implements Command {

    private ReportService reportService;

    public EditReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReportValidator reportValidator = new ReportValidator();
        Long id = Long.valueOf(request.getParameter(Parameters.REPORT_ID));
        LocalDate periodFrom = reportValidator.inputPeriodFrom(request);
        LocalDate periodTo = reportValidator.inputPeriodTo(request);
        Long revenue = reportValidator.inputRevenue(request);
        Double tax = reportValidator.inputTax(request);
        String commentary = reportValidator.inputCommentary(request);
        if (!reportValidator.isValid()) {
            return Pages.EDIT_REPORT_REDIRECT + "&" + id;
        }
        Long inspector_id = Long.valueOf(request.getParameter(Parameters.INSPECTOR_ID));
        Inspector inspector = new Inspector.InspectorBuilder().setId(inspector_id).build();
        Report report = new Report.ReportBuilder().setId(id).setInspector(inspector).setPeriodFrom(periodFrom).setPeriodTo(periodTo)
                .setRevenue(revenue).setTax(tax).setCommentary(commentary).build();
        reportService.update(report);
        return Pages.TAX_PAYER_REDIRECT;
    }
}
