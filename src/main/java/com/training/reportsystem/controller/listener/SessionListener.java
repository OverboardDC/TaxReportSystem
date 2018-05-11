package com.training.reportsystem.controller.listener;

import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.Attributes;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LoginUtil.logout(httpSessionEvent.getSession());
    }
}
