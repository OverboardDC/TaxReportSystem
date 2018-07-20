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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AllRequestsPage implements Command {

    private RequestService requestService;
    private InspectorService inspectorService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Request> requests = requestService.findByStatus(Status.PENDING);
        request.setAttribute(Attributes.REQUESTS, requests);
        request.setAttribute(Attributes.INSPECTORS, inspectorService.findAll());
        return Pages.ALL_REQUESTS;
    }

    @Autowired
    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

    @Autowired
    public void setInspectorService(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }
}
