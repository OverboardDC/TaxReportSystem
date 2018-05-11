package com.training.reportsystem.model.dao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoUtil {

    private static final String FILE_NAME = "queries.property";

    public static String getQuery(String key){
        try(InputStream in = DaoUtil.class.getClassLoader().getResourceAsStream(FILE_NAME)){
            Properties properties = new Properties();
            properties.load(in);
            return String.valueOf(properties.get(key));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
