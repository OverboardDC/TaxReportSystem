package com.training.reportsystem.util.constants;

public interface Pages {

    String INDEX = "/WEB-INF/view/index.jsp";
    String LOGIN = "/WEB-INF/view/login.jsp";
    String LOGIN_REDIRECT = "/app/loginPage";
    String REGISTRATION = "/WEB-INF/view/registration.jsp";
    String ADMIN = "/WEB-INF/view/adminPage.jsp";
    String REGISTRATION_REDIRECT = "app/registrationPage";
    String TAX_PAYER = "/WEB-INF/view/taxPayerPage.jsp";
    String TEST_INSPECTOR = "/WEB-INF/view/testInspectorPage.jsp";
    String INDEX_REDIRECT = "/app";
    String ADMIN_REDIRECT = "/app/admin/adminPage";
    String TAX_PAYER_REDIRECT = "/app/client/taxPayerPage";
    String REQUEST = "/WEB-INF/view/request.jsp";
    String REQUEST_REDIRECT = "/app/client/requestPage";
    String ALL_REQUESTS = "/WEB-INF/view/allRequests.jsp";
    String ALL_REQUESTS_REDIRECT = "/app/admin/allRequests";
    String NEW_REPORT = "/WEB-INF/view/newReport.jsp";
    String NEW_REPORT_REDIRECT = "/app/client/newReportPage";
}
