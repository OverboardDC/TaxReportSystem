package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.Command;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.util.LoggerUtil;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.GlobalConstants;
import com.training.reportsystem.util.constants.LoggerMessages;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute(Attributes.USER);
        LoginUtil.logout(request);
        logger.info(LoggerUtil.formMessage(LoggerMessages.USER, user.getUsername(), LoggerMessages.LOGOUT));
        return request.getHeader(GlobalConstants.REFERER_HEADER);
    }
}
