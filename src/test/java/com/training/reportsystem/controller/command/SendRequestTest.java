package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.RequestService;
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
public class SendRequestTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestService requestService;

    private SendRequest sendRequest;
    private String taxPayerId;
    private String inspectorId;
    private String reason;

    @Before
    public void setUp(){
        sendRequest = new SendRequest();
        taxPayerId = "1";
        inspectorId = "1";
        reason = "reason";
    }

    @Test
    public void sendRequestTest(){
        when(request.getParameter(Parameters.TAX_PAYER_ID)).thenReturn(taxPayerId);
        when(request.getParameter(Parameters.INSPECTOR_ID)).thenReturn(inspectorId);
        when(request.getParameter(Parameters.REASON)).thenReturn(reason);
        String page = sendRequest.execute(request, response);
        verify(requestService).create(any());
        assertEquals(page, Pages.TAX_PAYER_REDIRECT);
    }
}
