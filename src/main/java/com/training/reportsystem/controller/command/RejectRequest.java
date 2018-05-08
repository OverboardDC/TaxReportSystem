package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RejectRequest implements Command {

    private RequestService requestService;

    public RejectRequest(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String rejectReason = request.getParameter(Parameters.REJECT_REASON);
        if(rejectReason.isEmpty()){
            return Pages.ALL_REQUESTS_REDIRECT;
        }
        Long requestId = Long.valueOf(request.getParameter(Parameters.REQUEST_ID));
        requestService.reject(requestId,rejectReason);
        return Pages.ALL_REQUESTS_REDIRECT;
    }
}
