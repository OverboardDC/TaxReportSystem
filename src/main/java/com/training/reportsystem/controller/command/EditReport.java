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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

@Controller
public class EditReport implements Command {

    private ReportService reportService;

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
        Long taxpayer_id = Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID));
        Inspector inspector = new Inspector.InspectorBuilder().setId(inspector_id).build();
        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().setId(taxpayer_id).build();
        Report report = new Report.ReportBuilder().setId(id).setInspector(inspector).setPeriodFrom(periodFrom).setPeriodTo(periodTo)
                .setRevenue(revenue).setTax(tax).setTaxPayer(taxPayer).setStatus(Status.PENDING).setCommentary(commentary).build();
        reportService.update(report);
        logger.info(LoggerMessages.REPORT_WAS_UPDATED);
        return Pages.TAX_PAYER_REDIRECT;
    }

    @Autowired
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }
}
