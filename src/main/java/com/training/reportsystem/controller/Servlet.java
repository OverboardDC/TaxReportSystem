package com.training.reportsystem.controller;

import com.training.reportsystem.controller.command.*;
import com.training.reportsystem.controller.command.login.Login;
import com.training.reportsystem.controller.command.login.Logout;
import com.training.reportsystem.controller.command.login.Registration;
import com.training.reportsystem.controller.command.pages.*;
import com.training.reportsystem.controller.config.ApplicationConfig;
import com.training.reportsystem.model.service.*;
import com.training.reportsystem.model.service.factory.ServiceFactory;
import com.training.reportsystem.util.constants.Commands;
import com.training.reportsystem.util.constants.GlobalConstants;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/app/*")
public class Servlet extends HttpServlet {

    private Map<String, Command> commandMap;

    @Override
    public void init() throws ServletException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        commandMap = new HashMap<>();
        commandMap.put(Commands.HOME_PAGE, ac.getBean("homePage", HomePage.class));
        commandMap.put(Commands.LOGIN_PAGE, ac.getBean("loginPage", LoginPage.class));
        commandMap.put(Commands.REGISTRATION_PAGE, ac.getBean("registrationPage", RegistrationPage.class));
        commandMap.put(Commands.CHANGE_LANGUAGE, ac.getBean("changeLanguage", ChangeLanguage.class));
        commandMap.put(Commands.LOGIN, ac.getBean("login", Login.class));
        commandMap.put(Commands.ADMIN_PAGE, ac.getBean("adminPage", AdminPage.class));
        commandMap.put(Commands.TAX_PAYER_PAGE, ac.getBean("taxPayerPage", TaxPayerPage.class));
        commandMap.put(Commands.INSPECTOR_PAGE, ac.getBean("inspectorPage", InspectorPage.class));
        commandMap.put(Commands.REGISTRATION, ac.getBean("registration", Registration.class));
        commandMap.put(Commands.LOGOUT, ac.getBean("logout", Logout.class));
        commandMap.put(Commands.ASSIGN_INSPECTOR, ac.getBean("assignInspector", AssignInspector.class));
        commandMap.put(Commands.REQUEST_PAGE, ac.getBean("requestPage", RequestPage.class));
        commandMap.put(Commands.SEND_REQUEST, ac.getBean("sendRequest", SendRequest.class));
        commandMap.put(Commands.ALL_REQUESTS_PAGE, ac.getBean("allRequestsPage", AllRequestsPage.class));
        commandMap.put(Commands.ACCEPT_REQUEST, ac.getBean("acceptRequest", AcceptRequest.class));
        commandMap.put(Commands.REJECT_REQUEST, ac.getBean("rejectRequest", RejectRequest.class));
        commandMap.put(Commands.NEW_REPORT_PAGE, ac.getBean("newReportPage", NewReportPage.class));
        commandMap.put(Commands.SEND_REPORT, ac.getBean("sendReport", SendReport.class));
        commandMap.put(Commands.APPROVE_REPORT, ac.getBean("approveReport", ApproveReport.class));
        commandMap.put(Commands.REJECT_REPORT, ac.getBean("rejectReport", RejectReport.class));
        commandMap.put(Commands.EDIT_REPORT_PAGE, ac.getBean("editReportPage", EditReportPage.class));
        commandMap.put(Commands.EDIT_REPORT, ac.getBean("editReport", EditReport.class));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI().replaceAll(".*" + "/app/", "");
        Command command = commandMap.getOrDefault(url, commandMap.get(Commands.HOME_PAGE));
        if (url.contains(GlobalConstants.REDIRECT_URL_PATTERN)) {
            response.sendRedirect(command.execute(request, response));
        } else {
            request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
        }
    }
}
