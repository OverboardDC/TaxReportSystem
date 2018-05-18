package com.training.reportsystem.controller.command;

import com.training.reportsystem.controller.command.login.Login;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.model.service.impl.InspectorServiceImpl;
import com.training.reportsystem.model.service.impl.TaxPayerServiceImpl;
import com.training.reportsystem.model.service.util.Page;
import com.training.reportsystem.util.constants.Attributes;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;
import com.training.reportsystem.util.i18n.LocalisationUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginTest {



    @Mock
    private TaxPayerService taxPayerService;

    @Mock
    private InspectorService inspectorService;

    @InjectMocks
    private Login login = new Login(taxPayerService, inspectorService);

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
    public void loginTest(){
        when(request.getParameter(Parameters.USERNAME)).thenReturn(username);
        when(request.getParameter(Parameters.PASSWORD)).thenReturn(password);
        when(request.getSession()).thenReturn(session);
        when(session.getServletContext()).thenReturn(context);
        when(context.getAttribute(Attributes.USERS_IN_SYSTEM)).thenReturn(new HashSet<>());
        when(taxPayerService.login(anyString(), anyString())).thenReturn(taxPayer);
        String page = login.execute(request, response);
        Set users = (Set) context.getAttribute(Attributes.USERS_IN_SYSTEM);
        assertTrue(users.contains(taxPayer.getUsername()));
        assertEquals(page, Pages.INDEX_REDIRECT);
    }

}
