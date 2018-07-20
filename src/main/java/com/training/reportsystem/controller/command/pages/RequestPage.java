package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.TaxPayer;
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
import java.util.Optional;

@Controller
public class RequestPage implements Command {

    private RequestService requestService;
    private InspectorService inspectorService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        TaxPayer taxPayer = (TaxPayer) request.getSession().getAttribute(Attributes.USER);
        Optional<Inspector> inspector = Optional.ofNullable(inspectorService.getByUserId(taxPayer.getId()));
        if (!inspector.isPresent()) {
            return Pages.TAX_PAYER;
        }
        List<Request> requests = requestService.findByTaxPayerId(taxPayer.getId());
        request.setAttribute(Attributes.INSPECTOR, inspector.get());
        request.setAttribute(Attributes.ARE_THERE_REQUESTS_PENDING, requestService.areThereRequestsWithStatus(Status.PENDING, taxPayer.getId()));
        request.setAttribute(Attributes.REQUESTS, requests);
        return Pages.REQUEST;
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
