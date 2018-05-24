package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.PaginationUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllRequestsPage implements Command {

    private RequestService requestService;
    private InspectorService inspectorService;

    public AllRequestsPage(RequestService requestService, InspectorService inspectorService) {
        this.requestService = requestService;
        this.inspectorService = inspectorService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        int page = PaginationUtil.getPageParameter(request);
        Pagination pagination = new Pagination(page);
        List<Request> requests = requestService.findByStatus(Status.PENDING, pagination);
        PaginationUtil.setAttributeAndFill(pagination, request);
        if (pagination.isPageEmpty(requests)) {
            return Pages.ALL_REQUESTS_WITH_PAGE + pagination.getLastPageNum();
        }
        request.setAttribute(Attributes.REQUESTS, requests);
        request.setAttribute(Attributes.INSPECTORS, inspectorService.findAll());
        return Pages.ALL_REQUESTS;
    }
}
