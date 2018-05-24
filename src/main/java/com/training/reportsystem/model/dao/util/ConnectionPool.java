package com.training.reportsystem.model.dao.util;

import com.training.reportsystem.model.dao.ConnectionFailedException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private ConnectionPool() {
    }

    private static ConnectionPool instance;

    public static Connection getConnection() {
        try {
            return getInstance().getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionFailedException();
        }
    }

    private DataSource getDataSource() {
        try {
            InitialContext initialContext = new InitialContext();
            return (DataSource) initialContext.lookup("java:comp/env/jdbc/taxReportSystem");
        } catch (NamingException e) {
            throw new RuntimeException();
        }
    }

    private static ConnectionPool getInstance(){
        if(instance == null){
            synchronized (ConnectionPool.class){
                if(instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }
}
