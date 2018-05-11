package com.training.reportsystem.controller.command;

import com.training.reportsystem.controller.command.login.Logout;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.util.constants.Attributes;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.*;

public class LogoutTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private Logout logout;

    @Before
    public void setUp(){
        logout = mock(Logout.class);
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
    }

    @Test
    public void logoutTest(){
        when(request.getSession()).thenReturn(session);
        session.setAttribute(Attributes.USER, new User());
        logout.execute(request, response);
        assertNull(session.getAttribute(Attributes.USER));
    }
}
