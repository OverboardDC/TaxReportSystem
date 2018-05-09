package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RequestPage implements Command {

    private RequestService requestService;
    private InspectorService inspectorService;

    public RequestPage(RequestService requestService, InspectorService inspectorService) {
        this.requestService = requestService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        List<Request> requests = requestService.findByTaxPayerId(taxPayer.getId());
        request.setAttribute(Attributes.INSPECTOR, inspectorService.getByUserId(taxPayer.getId()));
        request.setAttribute(Attributes.ARE_THERE_REQUESTS_PENDING, requests.stream().anyMatch(i -> i.getStatus().equals(Status.PENDING)));
        request.setAttribute(Attributes.REQUESTS, requests);
        return Pages.REQUEST;
    }
}
