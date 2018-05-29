package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;
import com.training.reportsystem.util.LocalisationUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

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
        if(!reason.matches(RegexConstants.MESSAGE)){
            LocalisationUtil.setErrorMessage(Attributes.REASON_ERROR, ErrorMessages.INCORRECT_REASON, request);
            return Pages.REQUEST_REDIRECT;
        }
        Request taxPayerRequest = new Request.RequestBuilder()
                .setTaxPayer(new TaxPayer.TaxPayerBuilder().setId(taxPayerId).build())
                .setInspector(new Inspector.InspectorBuilder().setId(inspectorId).build())
                .setReason(reason).setStatus(Status.PENDING).setSubmissionDate(LocalDateTime.now()).build();
        requestService.create(taxPayerRequest);
        logger.info(LoggerUtil.formMessage(LoggerMessages.REQUEST_WAS_SENT));
        return Pages.TAX_PAYER_REDIRECT;
    }
}
