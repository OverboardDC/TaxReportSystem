package com.training.reportsystem.model.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Yevhen_Kushpii on 7/12/2018.
 */
public class SessionProvider {

    private static final SessionFactory SESSION_FACTORY = getConfig();

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }

    private static SessionFactory getConfig(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        return configuration.buildSessionFactory();
    }
    
}
