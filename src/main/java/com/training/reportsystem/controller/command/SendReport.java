package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.ReportValidator;
import com.training.reportsystem.util.constants.LoggerMessages;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SendReport implements Command {

    private ReportService reportService;

    public SendReport(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ReportValidator reportValidator = new ReportValidator();
        LocalDate periodFrom = reportValidator.inputPeriodFrom(request);
        LocalDate periodTo = reportValidator.inputPeriodTo(request);
        Long revenue = reportValidator.inputRevenue(request);
        Double tax = reportValidator.inputTax(request);
        String commentary = reportValidator.inputCommentary(request);
        if(!reportValidator.isValid()){
            return Pages.NEW_REPORT_REDIRECT;
        }
        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder()
                .setId(Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID))).build();
        Long inspector_id = Long.valueOf(request.getParameter(Parameters.INSPECTOR_ID));
        Inspector inspector = new Inspector.InspectorBuilder().setId(inspector_id).build();
        Report report = new Report.ReportBuilder().setPeriodFrom(periodFrom).setPeriodTo(periodTo).setStatus(Status.PENDING)
                .setRevenue(revenue).setTax(tax).setCommentary(commentary).setTaxPayer(taxPayer).setInspector(inspector)
                .setSubmissionDate(LocalDateTime.now()).build();
        reportService.create(report);
        logger.info(LoggerMessages.REPORT_WAS_CREATED);
        return Pages.TAX_PAYER_REDIRECT;
    }
}
