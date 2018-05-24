package com.training.reportsystem.model.dao;

import com.training.reportsystem.util.constants.LoggerMessages;

public class ConnectionFailedException extends RuntimeException {

    @Override
    public String getMessage() {
        return LoggerMessages.CONNECTION_FAILED;
    }
}
