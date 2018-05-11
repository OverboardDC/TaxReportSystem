package com.training.reportsystem.util.constants;

public interface Commands {

    // Pages
    String HOME_PAGE = "homePage";
    String LOGIN_PAGE = "loginPage";
    String REGISTRATION_PAGE = "registrationPage";
    String ADMIN_PAGE = "admin/adminPage";
    String TAX_PAYER_PAGE = "client/taxPayerPage";
    String INSPECTOR_PAGE = "inspector/inspectorPage";
    String REQUEST_PAGE = "client/requestPage";
    String ALL_REQUESTS_PAGE = "admin/allRequests";
    String NEW_REPORT_PAGE = "client/newReportPage";

    String CHANGE_LANGUAGE = "redirect/changeLanguage";

    String LOGIN = "redirect/login";
    String REGISTRATION = "redirect/registration";
    String LOGOUT = "redirect/logout";

    String ASSIGN_INSPECTOR = "redirect/admin/assignInspector";
    String SEND_REQUEST = "redirect/client/sendRequest";
    String ACCEPT_REQUEST = "redirect/admin/acceptRequest";
    String REJECT_REQUEST = "redirect/admin/rejectRequest";
    String SEND_REPORT = "redirect/client/sendReport";
    String APPROVE_REPORT = "redirect/inspector/approveReport";
    String REJECT_REPORT = "redirect/inspector/rejectReport";

}
