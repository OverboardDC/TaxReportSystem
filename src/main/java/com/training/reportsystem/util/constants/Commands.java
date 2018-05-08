package com.training.reportsystem.util.constants;

public interface Commands {

    // Pages
    String HOME_PAGE = "homePage";
    String LOGIN_PAGE = "loginPage";
    String REGISTRATION_PAGE = "registrationPage";
    String ADMIN_PAGE = "admin/adminPage";
    String TAX_PAYER_PAGE = "client/taxPayerPage";
    String TEST_INSPECTOR_PAGE = "inspector/testInspectorPage";
    String REQUEST_PAGE = "client/requestPage";
    String ALL_REQUESTS_PAGE = "admin/allRequests";

    String CHANGE_LANGUAGE = "redirect/changeLanguage";

    String LOGIN = "redirect/login";
    String REGISTRATION = "redirect/registration";
    String LOGOUT = "redirect/logout";

    String ASSIGN_INSPECTOR = "redirect/admin/assignInspector";
    String SEND_REQUEST = "redirect/client/sendRequest";
    String ACCEPT_REQUEST = "redirect/admin/acceptRequest";

}
