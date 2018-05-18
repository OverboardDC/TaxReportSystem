package com.training.reportsystem.controller.command;

import com.training.reportsystem.controller.command.login.Login;
import com.training.reportsystem.controller.command.login.Logout;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.LoginUtil;
import com.training.reportsystem.util.constants.Attributes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LogoutTest {

    @Mock
    private TaxPayerService taxPayerService;

    @Mock
    private InspectorService inspectorService;

    @InjectMocks
    private Logout logout = new Logout();

    @InjectMocks
    private String username = "testUsername";

    @InjectMocks
    private String password = "testPassword";

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private ServletContext context;

    @InjectMocks
    private TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().setUsername("test").setPassword("test").build();

    @Test
    public void logoutTest(){
        Set<String> users = new HashSet<>();
        when(request.getSession()).thenReturn(session);
        when(context.getAttribute(Attributes.USERS_IN_SYSTEM)).thenReturn(users);
        when(session.getServletContext()).thenReturn(context);
        users.add(taxPayer.getUsername());
        logout.execute(request, response);
        assertNull(request.getSession().getAttribute(Attributes.USER));
        Set usersAfter = (Set) context.getAttribute(Attributes.USERS_IN_SYSTEM);
        assertFalse(usersAfter.contains(taxPayer));
    }
}
