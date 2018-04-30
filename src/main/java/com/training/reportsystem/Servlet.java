package com.training.reportsystem;

import com.training.reportsystem.command.ChangeLanguage;
import com.training.reportsystem.command.Command;
import com.training.reportsystem.command.pages.HomePage;
import com.training.reportsystem.command.pages.LoginPage;
import com.training.reportsystem.command.pages.RegistrationPage;
import com.training.reportsystem.util.constants.CommandConstants;
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
        commandMap.put(CommandConstants.HOME_PAGE, new HomePage());
        commandMap.put(CommandConstants.LOGIN_PAGE, new LoginPage());
        commandMap.put(CommandConstants.REGISTRATION_PAGE, new RegistrationPage());
        commandMap.put(CommandConstants.CHANGE_LANGUAGE, new ChangeLanguage());
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
        Command command = commandMap.getOrDefault(url, commandMap.get(CommandConstants.HOME_PAGE));

        if (url.contains(GlobalConstants.REDIRECT_URL_PATTERN)) {
            response.sendRedirect(command.execute(request, response));
        } else {
            request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
        }
    }
}
