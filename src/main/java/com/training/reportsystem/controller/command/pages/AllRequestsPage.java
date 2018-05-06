package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllRequestsPage implements Command {

    private RequestService requestService;
    private InspectorService inspectorService;

    public AllRequestsPage(RequestService requestService, InspectorService inspectorService) {
        this.requestService = requestService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute(Attributes.REQUESTS, requestService.findAll());
        request.setAttribute(Attributes.INSPECTORS, inspectorService.findAll());
        return Pages.ALL_REQUESTS;
    }
}
