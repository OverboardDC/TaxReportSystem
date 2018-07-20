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
public class ApproveReportTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private ReportService reportService;

    private ApproveReport approveReport;
    private Long reportId;

    @Before
    public void setUp(){
        approveReport = new ApproveReport();
        reportId = 1L;
    }

    @Test
    public void approveReportTest(){
        when(request.getParameter(Parameters.REPORT_ID)).thenReturn(String.valueOf(reportId));
        String page = approveReport.execute(request, response);
        verify(reportService).approveReport(reportId);
        assertEquals(page, Pages.INSPECTOR_REDIRECT);
    }

}
