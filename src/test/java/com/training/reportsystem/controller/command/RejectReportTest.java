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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RejectReportTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ReportService reportService;

    private RejectReport rejectReport;
    private Long reportId;
    private String rejectReason;

    @Before
    public void setUp(){
        rejectReport = new RejectReport(reportService);
        reportId = 1L;
        rejectReason = "reason";
    }

    @Test
    public void rejectReportTest(){
        when(request.getParameter(Parameters.REPORT_ID)).thenReturn(String.valueOf(reportId));
        when(request.getParameter(Parameters.REJECT_REASON)).thenReturn(rejectReason);
        String page = rejectReport.execute(request, response);
        verify(reportService).rejectReport(reportId, rejectReason);
        assertEquals(page, Pages.INSPECTOR_REDIRECT);
    }
}
