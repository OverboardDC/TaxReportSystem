package com.training.reportsystem.controller.command;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    Logger logger = Logger.getRootLogger();

    String execute(HttpServletRequest request, HttpServletResponse response);
}
