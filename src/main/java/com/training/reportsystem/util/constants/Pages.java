package com.training.reportsystem.util.constants;

public interface Pages {

    String INDEX = "/WEB-INF/view/pages/index.jsp";
    String LOGIN = "/WEB-INF/view/pages/login.jsp";
    String LOGIN_REDIRECT = "/app/loginPage";
    String REGISTRATION = "/WEB-INF/view/pages/registration.jsp";
    String ADMIN = "/WEB-INF/view/pages/admin/adminPage.jsp";
    String REGISTRATION_REDIRECT = "app/registrationPage";
    String TAX_PAYER = "/WEB-INF/view/pages/taxpayer/taxPayerPage.jsp";
    String INSPECTOR = "/WEB-INF/view/pages/inspector/inspectorPage.jsp";
    String INDEX_REDIRECT = "/app";
    String ADMIN_REDIRECT = "/app/admin/adminPage";
    String TAX_PAYER_REDIRECT = "/app/client/taxPayerPage";
    String REQUEST = "/WEB-INF/view/pages/taxpayer/request.jsp";
    String REQUEST_REDIRECT = "/app/client/requestPage";
    String ALL_REQUESTS = "/WEB-INF/view/pages/admin/allRequests.jsp";
    String ALL_REQUESTS_REDIRECT = "/app/admin/allRequests";
    String NEW_REPORT = "/WEB-INF/view/pages/taxpayer/newReport.jsp";
    String NEW_REPORT_REDIRECT = "/app/client/newReportPage";
    String INSPECTOR_REDIRECT = "/app/inspector/inspectorPage";
    String EDIT_REPORT = "/WEB-INF/view/pages/taxpayer/editReport.jsp";
    String EDIT_REPORT_REDIRECT = "/app/client/editReportPage";
    String TAX_PAYER_WITH_PAGE = "taxPayerPage?page=";
    String INSPECTOR_WITH_PAGE = "inspectorPage?page=";
    String ALL_REQUESTS_WITH_PAGE = "allRequests?page=";
    String REQUEST_WITH_PAGE = "requestPage?page=";
    String ADMIN_WITH_PAGE =  "adminPage?page=";
}
