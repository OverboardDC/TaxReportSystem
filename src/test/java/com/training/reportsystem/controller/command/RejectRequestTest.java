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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RejectRequestTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestService requestService;

    private RejectRequest rejectRequest;
    private Long requestId;
    private String rejectReason;

    @Before
    public void setUp(){
        rejectRequest = new RejectRequest(requestService);
        requestId = 1L;
        rejectReason = "Reason";
    }

    @Test
    public void rejectRequestTest(){
       when(request.getParameter(Parameters.REQUEST_ID)).thenReturn(String.valueOf(requestId));
       when(request.getParameter(Parameters.REJECT_REASON)).thenReturn(rejectReason);
       String page = rejectRequest.execute(request, response);
       verify(requestService).reject(requestId, rejectReason);
       assertEquals(page, Pages.ALL_REQUESTS_REDIRECT);
    }
}
