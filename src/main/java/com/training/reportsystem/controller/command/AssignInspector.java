package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.constants.*;
import com.training.reportsystem.util.i18n.LocalisationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class AssignInspector implements Command{

    private TaxPayerService taxPayerService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Long taxPayerId = Long.valueOf(request.getParameter(Parameters.TAX_PAYER_ID));
        Optional<String> inspectorId = Optional.ofNullable(request.getParameter(Parameters.INSPECTOR_ID));
        if(!inspectorId.isPresent()){
            request.getSession().setAttribute(Attributes.ADMIN_PAGE_ERROR,
                    LocalisationUtil.getMessage(ErrorMessages.INSPECTOR_WASNT_CHOSEN));
            return Pages.ADMIN_REDIRECT;
        }
        taxPayerService.assignInspector(taxPayerId, Long.valueOf(inspectorId.get()));
        logger.info(LoggerUtil.formMessage(LoggerMessages.INSPECTOR_ASSIGNED));
        return Pages.ADMIN_REDIRECT;
    }

    @Autowired
    public void setTaxPayerService(TaxPayerService taxPayerService) {
        this.taxPayerService = taxPayerService;
    }
}
