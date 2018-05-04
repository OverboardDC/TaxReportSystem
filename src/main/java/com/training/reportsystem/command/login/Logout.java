package com.training.reportsystem.command.login;

import com.training.reportsystem.command.Command;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.GlobalConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Logout implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        LoginUtil.logout(request);
        return request.getHeader(GlobalConstants.REFERER_HEADER);
    }
}
