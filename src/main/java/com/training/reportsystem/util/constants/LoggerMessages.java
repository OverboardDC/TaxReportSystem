package com.training.reportsystem.util.constants;

public interface LoggerMessages {

    String USER ="USER:";
    String LOGIN_SUCCESS = "Login successfully";
    String LOGIN_FAILED = "login failed for username:";
    String LOGOUT = "logout";
    String REGISTRATION_FAILED = "Registration failed";
    String REGISTRATION_SUCCESS = "Registration successfully";
    String REASON = "REASON:";
    String INVALID_DATA = "Invalid data";
    String USER_ALREADY_LOGINED = "User already is in the system";
    String DUPLICATED_USERNAME = "Duplicated username";
    String REQUEST_ACCEPTED = "Request was accepted";
    String INSPECTOR_ASSIGNED = "Inspector was assigned";
    String REQUEST_WAS_REJECTED = "Request was rejected";
    String REQUEST_WAS_SENT = "Request was sent";
    String SQL_EXCEPTION = "Sql exception";
    String REPORT_WAS_CREATED = "Report was created";
    String SESSION_WAS_CREATED = "Session was created";
    String SESSION_WAS_DESTROYED = "Session was destroyed";
    String CONTEXT_WAS_INITIALIZED = "Context was initialized";
    String CONTEXT_WAS_DESTROYED = "Context was destroyed";
    String REPORT_WAS_APPROVED = "Report was approved";
    String REPORT_WAS_UPDATED = "Report was updated";
    Object CONNECTION_FAILED = "Connection failed";
}
