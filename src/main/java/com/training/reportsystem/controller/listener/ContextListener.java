package com.training.reportsystem.controller.listener;

import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.LoggerMessages;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashSet;

@WebListener
public class ContextListener implements ServletContextListener, Listener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        HashSet<String> usersInSystem = new HashSet<>();
        servletContextEvent.getServletContext().setAttribute(Attributes.USERS_IN_SYSTEM, usersInSystem);
        logger.debug(LoggerMessages.CONTEXT_WAS_INITIALIZED);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.debug(LoggerMessages.CONTEXT_WAS_DESTROYED);
    }
}
