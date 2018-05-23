package com.training.reportsystem.model.dao.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private ConnectionPool() {
    }

    private static ConnectionPool instance;

    public static Connection getConnection() throws SQLException {
       return getInstance().getDataSource().getConnection();
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
