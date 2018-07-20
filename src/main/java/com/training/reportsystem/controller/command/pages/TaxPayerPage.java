package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.PaginationUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class TaxPayerPage implements Command {

    private InspectorService inspectorService;
    private ReportService reportService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        List<Report> reports = reportService.findAllByUser(user.getId());
        request.setAttribute(Attributes.REPORTS, reports);
        request.setAttribute(Attributes.INSPECTOR, inspectorService.getByUserId(user.getId()));
        return Pages.TAX_PAYER;
    }

    @Autowired
    public void setInspectorService(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @Autowired
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }
}
