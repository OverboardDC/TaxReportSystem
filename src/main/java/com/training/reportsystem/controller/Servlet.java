package com.training.reportsystem.controller;

import com.training.reportsystem.controller.command.AssignInspector;
import com.training.reportsystem.controller.command.ChangeLanguage;
import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.controller.command.SendRequest;
import com.training.reportsystem.controller.command.login.Login;
import com.training.reportsystem.controller.command.login.Logout;
import com.training.reportsystem.controller.command.login.Registration;
import com.training.reportsystem.controller.command.pages.*;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.RequestService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.impl.InspectorServiceImpl;
import com.training.reportsystem.model.service.impl.RequestServiceImpl;
import com.training.reportsystem.model.service.impl.TaxPayerServiceImpl;
import com.training.reportsystem.util.constants.Commands;
import com.training.reportsystem.util.constants.GlobalConstants;

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
        commandMap = new HashMap<>();
        TaxPayerService taxPayerService = new TaxPayerServiceImpl();
        InspectorService inspectorService = new InspectorServiceImpl();
        RequestService requestService = new RequestServiceImpl();
        commandMap.put(Commands.HOME_PAGE, new HomePage());
        commandMap.put(Commands.LOGIN_PAGE, new LoginPage());
        commandMap.put(Commands.REGISTRATION_PAGE, new RegistrationPage());
        commandMap.put(Commands.CHANGE_LANGUAGE, new ChangeLanguage());
        commandMap.put(Commands.LOGIN, new Login(taxPayerService, inspectorService));
        commandMap.put(Commands.ADMIN_PAGE, new AdminPage(taxPayerService, inspectorService));
        commandMap.put(Commands.TAX_PAYER_PAGE, new TaxPayerPage());
        commandMap.put(Commands.TEST_INSPECTOR_PAGE, new TestInspectorPage());
        commandMap.put(Commands.REGISTRATION, new Registration(taxPayerService));
        commandMap.put(Commands.LOGOUT, new Logout());
        commandMap.put(Commands.ASSIGN_INSPECTOR, new AssignInspector(taxPayerService));
        commandMap.put(Commands.REQUEST_PAGE, new RequestPage());
        commandMap.put(Commands.SEND_REQUEST, new SendRequest(requestService));
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
        System.out.println("URL: " + url);
        Command command = commandMap.getOrDefault(url, commandMap.get(Commands.HOME_PAGE));

        if (url.contains(GlobalConstants.REDIRECT_URL_PATTERN)) {
            response.sendRedirect(command.execute(request, response));
        } else {
            request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
        }
    }
}
