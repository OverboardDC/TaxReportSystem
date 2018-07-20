package com.training.reportsystem.controller.command;

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
public class AssignInspectorTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private TaxPayerService taxPayerService;

    private AssignInspector assignInspector;
    private Long taxPayerId;
    private Long inspectorId;

    @Before
    public void setUp(){
        assignInspector = new AssignInspector();
        taxPayerId = 1L;
        inspectorId = 1L;
    }

    @Test
    public void assignInspectorTest(){
        when(request.getParameter(Parameters.TAX_PAYER_ID)).thenReturn(String.valueOf(taxPayerId));
        when(request.getParameter(Parameters.INSPECTOR_ID)).thenReturn(String.valueOf(inspectorId));
        String page = assignInspector.execute(request, response);
        verify(taxPayerService).assignInspector(taxPayerId, inspectorId);
        assertEquals(page, Pages.ADMIN_REDIRECT);
    }
}
