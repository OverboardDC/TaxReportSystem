package com.training.reportsystem.model.dao.util.constant;

public interface Queries {

    //Used queries
    String TAX_PAYER_LOGIN = "tax.payer.login";
    String INSPECTOR_LOGIN = "inspector.login";
    String CREATE_TAX_PAYER = "create.tax.payer";
    String IS_TAX_PAYER_USERNAME_UNIQUE = "is.tax.payer.username.unique";
    String IS_INSPECTOR_USERNAME_UNIQUE = "is.inspector.username.unique";
    String FIND_ALL_TAX_PAYERS_WITHOUT_INSPECTOR = "find.all.taxpayers.without.inspector";
    String FIND_ALL_INSPECTORS = "find.all.inspectors";
    String ASSIGN_INSPECTOR = "assign.inspector";
    String CREATE_REQUEST = "create.request";
    String FIND_ALL_REQUESTS = "find.all.requests";
    String FIND_ALL_REQUESTS_BY_STATUS = "find.all.requests.by.status";
    String FIND_REQUESTS_BY_TAX_PAYER = "find.requests.by.tax.payer";
    String ACCEPT_REQUEST = "accept.request";
    String REJECT_REQUEST = "reject.request";
    String GET_INSPECTOR_BY_USER = "get.inspector.by.user";
    String CREATE_REPORT = "create.report";
    String FIND_ALL_REPORTS_BY_USER = "find.all.reports.by.user";
    String FIND_ALL_REPORTS_BY_INSPECTOR = "find.all.reports.by.inspector";
    String APPROVE_REPORT = "approve.report";
    String REJECT_REPORT = "reject.report";
    String GET_REPORT_BY_ID = "get.report.by.id";
    String UPDATE_REPORT = "update.report";
    String ARE_THERE_REQUESTS_STATUS = "are.there.requests.status";

    //Count queries for pagination
    String GET_COUNT_ALL_REPORTS_BY_USER = "get.count.all.reports.by.user";
    String GET_COUNT_ALL_REPORTS_BY_INSPECTOR = "get.count.all.reports.by.inspector";
    String GET_COUNT_ALL_REQUESTS_BY_STATUS = "get.count.all.requests.by.status";
    String GET_COUNT_ALL_REQUESTS_BY_TAX_PAYER = "get.count.all.requests.by.tax.payer";
    String GET_COUNT_ALL_TAX_PAYERS_WITHOUT_INSPECTOR = "get.count.all.tax.payers.without.inspector";

    //Unused queries
    String GET_INSPECTOR_BY_ID = "get.inspector.by.id";
    String CREATE_INSPECTOR = "create.inspector";
    String UPDATE_INSPECTOR = "update.inspector";
    String DELETE_INSPECTOR = "delete.inspector";

    String FIND_ALL_REPORTS = "find.all.reports";
    String DELETE_REPORT = "delete.report";

    String GET_REQUEST_BY_ID = "get.request.by.id";
    String UPDATE_REQUEST = "update.request";
    String DELETE_REQUEST = "delete.request";

    String FIND_ALL_TAX_PAYERS = "find.all.taxpayers";
    String GET_TAX_PAYER_BY_ID = "get.taxpayer.by.id";
    String UPDATE_TAX_PAYER = "update.taxpayer";
    String DELETE_TAX_PAYER = "delete.taxpayer";
}
