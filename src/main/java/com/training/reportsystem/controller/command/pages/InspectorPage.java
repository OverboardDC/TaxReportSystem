package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.PaginationUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class InspectorPage implements Command {

    private ReportService reportService;

    public InspectorPage(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int page = PaginationUtil.getPageParameter(request);
        Pagination pagination = new Pagination(page);
        Inspector inspector = (Inspector) request.getSession().getAttribute(Attributes.USER);
        List<Report> reports = reportService.findAllByInspector(inspector.getId(), pagination);
        PaginationUtil.setAttributeAndFill(pagination, request);
        if (pagination.isPageEmpty(reports)) {
            return Pages.INSPECTOR_WITH_PAGE + pagination.getLastPageNum();
        }
        request.setAttribute(Attributes.REPORTS, reports);
        return Pages.INSPECTOR;
    }
}
