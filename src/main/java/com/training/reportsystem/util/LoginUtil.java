package com.training.reportsystem.util;

import com.training.reportsystem.util.constants.Attributes;

import javax.servlet.http.HttpServletRequest;

public class LoginUtil {

    public static void logout(HttpServletRequest request){
        request.getSession().removeAttribute(Attributes.USER);
    }
}
