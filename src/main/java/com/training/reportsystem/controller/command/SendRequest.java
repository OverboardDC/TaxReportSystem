package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.Request;
import com.training.reportsystem.model.entity.user.TaxPayer;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.LocalisationUtil;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRequest implements Command {

    private RequestService requestService;

    public SendRequest(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long taxPayerId = Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID));
        Long inspectorId = Long.valueOf(request.getParameter(Parameters.INSPECTOR_ID));
        String reason = request.getParameter(Parameters.REASON);
        if(reason.isEmpty()){
            request.getSession().setAttribute(Attributes.REASON_ERROR, LocalisationUtil.getMessage(ErrorMessages.INCORRECT_REASON));
            return Pages.REQUEST_REDIRECT;
        }
        Request taxPayerRequest = new Request.RequestBuilder()
                .setTaxPayer(new TaxPayer.TaxPayerBuilder().setId(taxPayerId).build())
                .setInspector(new Inspector.InspectorBuilder().setId(inspectorId).build())
                .setReason(reason).setStatus(Status.PENDING).build();
        requestService.create(taxPayerRequest);
        logger.info(LoggerUtil.formMessage(LoggerMessages.REQUEST_WAS_SENT));
        return Pages.TAX_PAYER_REDIRECT;
    }
}
