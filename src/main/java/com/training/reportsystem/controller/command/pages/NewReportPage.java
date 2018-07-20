package com.training.reportsystem.controller.command.pages;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class NewReportPage implements Command {

    private InspectorService inspectorService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        Optional<Inspector> inspector = Optional.ofNullable(inspectorService.getByUserId(user.getId()));
        if(!inspector.isPresent()){
            return Pages.TAX_PAYER_REDIRECT;
        }
        request.setAttribute(Attributes.INSPECTOR, inspector.get());
        return Pages.NEW_REPORT;
    }

    @Autowired
    public void setInspectorService(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }
}
