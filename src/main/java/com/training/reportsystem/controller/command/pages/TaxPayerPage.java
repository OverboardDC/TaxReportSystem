package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.PaginationUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TaxPayerPage implements Command {

    private InspectorService inspectorService;
    private ReportService reportService;

    public TaxPayerPage(InspectorService inspectorService, ReportService reportService) {
        this.inspectorService = inspectorService;
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int page = PaginationUtil.getPageParameter(request);
        Pagination pagination = new Pagination(page);
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        List<Report> reports = reportService.findAllByUser(taxPayer.getId(), pagination);
        PaginationUtil.setAttribute(pagination, request);
        if (pagination.isPageEmpty(reports)) {
            return Pages.TAX_PAYER_WITH_PAGE + pagination.getLastPageNum();
        }
        request.setAttribute(Attributes.REPORTS, reports);
        request.setAttribute(Attributes.INSPECTOR, inspectorService.getByUserId(taxPayer.getId()));
        return Pages.TAX_PAYER;
    }
}
