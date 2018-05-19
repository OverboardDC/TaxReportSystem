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

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EditReportTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ReportService reportService;

    private EditReport editReport;
    private String periodFrom;
    private String periodTo;
    private String revenue;
    private String tax;
    private String commentary;
    private String taxPayerId;
    private String inspectorId;
    private Long reportId;

    @Before
    public void setUp(){
        editReport = new EditReport(reportService);
        periodFrom = "2018-01-01";
        periodTo = "2018-01-01";
        revenue = "123.56";
        tax = "34";
        commentary = "Commentary";
        taxPayerId = "1";
        inspectorId = "1";
        reportId = 1L;
    }

    @Test
    public void editReportTest(){
        when(request.getParameter(Parameters.PERIOD_FROM)).thenReturn(periodFrom);
        when(request.getParameter(Parameters.PERIOD_TO)).thenReturn(periodTo);
        when(request.getParameter(Parameters.REVENUE)).thenReturn(revenue);
        when(request.getParameter(Parameters.TAX)).thenReturn(tax);
        when(request.getParameter(Parameters.COMMENTARY)).thenReturn(commentary);
        when(request.getParameter(Parameters.TAX_PAYER_ID)).thenReturn(taxPayerId);
        when(request.getParameter(Parameters.INSPECTOR_ID)).thenReturn(inspectorId);
        when(request.getParameter(Parameters.REPORT_ID)).thenReturn(String.valueOf(reportId));
        String page = editReport.execute(request, response);
        verify(reportService).update(any());
        assertEquals(page, Pages.TAX_PAYER_REDIRECT);
    }
}
