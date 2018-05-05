package com.training.reportsystem.model.dao.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {

    private ConnectionPool() {
    }

    private static ConnectionPool instance;

    public DataSource getDataSource() {
        try {
            InitialContext initialContext = new InitialContext();
            return (DataSource) initialContext.lookup("java:comp/env/jdbc/taxReportSystem");
        } catch (NamingException e) {
            return null;
        }
    }

    public static ConnectionPool getInstance(){
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
