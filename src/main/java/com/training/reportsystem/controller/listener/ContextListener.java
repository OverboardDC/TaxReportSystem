package com.training.reportsystem.controller.listener;

import com.training.reportsystem.util.constants.Attributes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HashSet<String> usersInSystem = new HashSet<>();
        servletContextEvent.getServletContext().setAttribute(Attributes.USERS_IN_SYSTEM, usersInSystem);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
