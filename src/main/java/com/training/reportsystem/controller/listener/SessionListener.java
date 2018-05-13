package com.training.reportsystem.controller.listener;

import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.LoggerMessages;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, Listener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        logger.debug(LoggerMessages.SESSION_WAS_CREATED);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LoginUtil.logout(httpSessionEvent.getSession());
        logger.debug(LoggerMessages.SESSION_WAS_DESTROYED);
    }
}
