package com.training.reportsystem.model.dao.util.constant;

public interface Queries {

    String TAX_PAYER_LOGIN = "tax.payer.login";
    String INSPECTOR_LOGIN = "inspector.login";
    String CREATE_TAX_PAYER = "create.tax.payer";
    String IS_USERNAME_UNIQUE = "is.username.unique";
    String FIND_ALL_TAX_PAYERS_WITHOUT_INSPECTOR = "find.all.taxpayers.without.inspector";
    String FIND_ALL_INSPECTORS = "find.all.inspectors";
    String ASSIGN_INSPECTOR = "assign.inspector";
    String CREATE_REQUEST = "create.request";
    String FIND_ALL_REQUESTS = "find.all.requests";
    String FIND_REQUESTS_BY_TAX_PAYER = "find.requests.by.tax.payer";
}
