package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO Temporary
public class AdminPage implements Command {

    private TaxPayerService taxPayerService;
    private InspectorService inspectorService;

    public AdminPage(TaxPayerService taxPayerService, InspectorService inspectorService) {
        this.taxPayerService = taxPayerService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(Attributes.TAX_PAYERS, taxPayerService.findAllWithoutInspector());
        request.setAttribute(Attributes.INSPECTORS, inspectorService.findAll());
        return Pages.ADMIN;
    }
}
