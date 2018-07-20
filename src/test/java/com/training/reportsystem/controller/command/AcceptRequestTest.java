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
public class AcceptRequestTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestService requestService;

    private AcceptRequest acceptRequest;
    private Long requestId;
    private Long taxPayerId;
    private Long inspectorId;

    @Before
    public void setUp(){
        acceptRequest = new AcceptRequest();
        requestId = 1L;
        taxPayerId = 1L;
        inspectorId = 1L;
    }

    @Test
    public void acceptRequestTest(){
        when(request.getParameter(Parameters.REQUEST_ID)).thenReturn(String.valueOf(requestId));
        when(request.getParameter(Parameters.TAX_PAYER_ID)).thenReturn(String.valueOf(taxPayerId));
        when(request.getParameter(Parameters.INSPECTOR_ID)).thenReturn(String.valueOf(inspectorId));
        String page = acceptRequest.execute(request, response);
        verify(requestService).accept(requestId, taxPayerId, inspectorId);
        assertEquals(page, Pages.ALL_REQUESTS_REDIRECT);
    }
}
