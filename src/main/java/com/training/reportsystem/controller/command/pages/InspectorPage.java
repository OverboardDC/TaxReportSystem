package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InspectorPage implements Command {

    private ReportService reportService;

    public InspectorPage(ReportService reportService) {
        this.reportService = reportService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Inspector inspector = (Inspector) request.getSession().getAttribute(Attributes.USER);
        request.setAttribute(Attributes.REPORTS, reportService.findAllByInspector(inspector.getId()));
        return Pages.INSPECTOR;
    }
}
