package com.training.reportsystem.controller.command.login;

import com.training.reportsystem.controller.command.login.Registration;
import com.training.reportsystem.model.service.InspectorService;
import com.training.reportsystem.model.service.TaxPayerService;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationTest {

    @Mock
    private TaxPayerService taxPayerService;

    @Mock
    private InspectorService inspectorService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    private Registration registration;
    private String firstName;
    private String lastName;
    private String identificationCode;
    private String username;
    private String password;
    private String passwordRepeat;

    @Before
    public void setUp() {
        registration = new Registration(taxPayerService, inspectorService);
        firstName = "firstName";
        lastName = "lastName";
        identificationCode = "183957382";
        username = "usernameUnique";
        password = "password";
        passwordRepeat = "password";
    }

    @Test
    public void registrationTest() {
        when(request.getParameter(Parameters.FIRST_NAME)).thenReturn(firstName);
        when(request.getParameter(Parameters.LAST_NAME)).thenReturn(lastName);
        when(request.getParameter(Parameters.IDENTIFICATION_CODE)).thenReturn(identificationCode);
        when(request.getParameter(Parameters.USERNAME)).thenReturn(username);
        when(request.getParameter(Parameters.PASSWORD)).thenReturn(password);
        when(request.getParameter(Parameters.PASSWORD_REPEAT)).thenReturn(passwordRepeat);
        when(taxPayerService.isUsernameUnique(username)).thenReturn(true);
        when(inspectorService.isUsernameUnique(username)).thenReturn(true);
        String page = registration.execute(request, response);
        verify(taxPayerService).create(any());
        assertEquals(page, Pages.LOGIN_REDIRECT);
    }
}
