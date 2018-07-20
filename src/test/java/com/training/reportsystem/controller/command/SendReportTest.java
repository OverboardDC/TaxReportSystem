package com.training.reportsystem.controller.command;

import com.training.reportsystem.model.service.ReportService;
import com.training.reportsystem.util.constants.Pages;
import com.training.reportsystem.util.constants.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SendReportTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ReportService reportService;

    private SendReport sendReport;
    private String periodFrom;
    private String periodTo;
    private String revenue;
    private String tax;
    private String commentary;
    private String taxPayerId;
    private String inspectorId;

    @Before
    public void setUp(){
        sendReport = new SendReport();
        periodFrom = "2018-01-01";
        periodTo = "2018-02-01";
        revenue = "123.56";
        tax = "34";
        commentary = "Commentary";
        taxPayerId = "1";
        inspectorId = "1";
    }

    @Test
    public void sendReportTest(){
        when(request.getParameter(Parameters.PERIOD_FROM)).thenReturn(periodFrom);
        when(request.getParameter(Parameters.PERIOD_TO)).thenReturn(periodTo);
        when(request.getParameter(Parameters.REVENUE)).thenReturn(revenue);
        when(request.getParameter(Parameters.TAX)).thenReturn(tax);
        when(request.getParameter(Parameters.COMMENTARY)).thenReturn(commentary);
        when(request.getParameter(Parameters.TAX_PAYER_ID)).thenReturn(taxPayerId);
        when(request.getParameter(Parameters.INSPECTOR_ID)).thenReturn(inspectorId);
        String page = sendReport.execute(request, response);
        verify(reportService).create(any());
        assertEquals(page, Pages.TAX_PAYER_REDIRECT);
    }

}
