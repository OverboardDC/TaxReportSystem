package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
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
public class AdminPage implements Command {

    private TaxPayerService taxPayerService;
    private InspectorService inspectorService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int page = PaginationUtil.getPageParameter(request);
        Pagination pagination = new Pagination(page);
        List<TaxPayer> taxPayers = taxPayerService.findAllWithoutInspector();
        PaginationUtil.setAttributeAndFill(pagination, request);
        if (pagination.isPageEmpty(taxPayers)) {
            return Pages.ADMIN_WITH_PAGE + pagination.getLastPageNum();
        }
        request.setAttribute(Attributes.TAX_PAYERS, taxPayers);
        request.setAttribute(Attributes.INSPECTORS, inspectorService.findAll());
        return Pages.ADMIN;
    }

    @Autowired
    public void setTaxPayerService(TaxPayerService taxPayerService) {
        this.taxPayerService = taxPayerService;
    }

    @Autowired
    public void setInspectorService(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }
}
