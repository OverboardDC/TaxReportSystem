package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;
import com.training.reportsystem.util.i18n.LocalisationUtil;

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
            request.getSession().setAttribute(Attributes.ALL_REQUESTS_PAGE_ERROR,
                    LocalisationUtil.getMessage(ErrorMessages.INCORRECT_REASON));
            return Pages.ALL_REQUESTS_REDIRECT;
        }
        Long requestId = Long.valueOf(request.getParameter(Parameters.REQUEST_ID));
        requestService.reject(requestId,rejectReason);
        logger.info(LoggerUtil.formMessage(LoggerMessages.REQUEST_WAS_REJECTED));
        return Pages.ALL_REQUESTS_REDIRECT;
    }
}
