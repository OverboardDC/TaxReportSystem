package com.training.reportsystem.util;

import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.ErrorMessages;
import com.training.reportsystem.util.constants.LoggerMessages;
import com.training.reportsystem.util.constants.Pages;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Optional;

import static com.training.reportsystem.util.constants.LoggerMessages.LOGIN_SUCCESS;
import static com.training.reportsystem.util.constants.LoggerMessages.USER;

public class LoginUtil {

    private static Logger logger = Logger.getRootLogger();

    public static String authorizeUser(User user, HttpServletRequest request){
        HashSet usersInSystem = getUsersFromContext(request.getSession());
        if (usersInSystem.contains(user.getUsername())){
            request.getSession().setAttribute(Attributes.LOGIN_ERROR, LocalisationUtil.getMessage(ErrorMessages.USER_ALREADY_LOGINED));
            return Pages.LOGIN_REDIRECT;
        }
        request.getSession().setAttribute(Attributes.USER, user);

        usersInSystem.add(user.getUsername());
        updateUsersAttribute(request.getSession(), usersInSystem);

        logger.info(LoggerUtil.formMessage(LOGIN_SUCCESS, USER, user.getUsername()));
        return Pages.INDEX_REDIRECT;
    }

    public static void logout(HttpSession session) {
        Optional<User> user = Optional.ofNullable((User) session.getAttribute(Attributes.USER));
        if (user.isPresent()) {
            session.removeAttribute(Attributes.USER);

            HashSet usersInSystem = getUsersFromContext(session);
            usersInSystem.remove(user.get().getUsername());
            updateUsersAttribute(session, usersInSystem);
            logger.info(LoggerUtil.formMessage(LoggerMessages.USER, user.get().getUsername(), LoggerMessages.LOGOUT));
        }
    }

    private static HashSet getUsersFromContext(HttpSession session){
        return (HashSet) session.getServletContext().getAttribute(Attributes.USERS_IN_SYSTEM);
    }

    private static void updateUsersAttribute(HttpSession session, HashSet usersInSystem){
        session.getServletContext().setAttribute(Attributes.USERS_IN_SYSTEM, usersInSystem);
    }
}
