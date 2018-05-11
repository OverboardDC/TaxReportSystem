package com.training.reportsystem.util;

public class LoggerUtil {

    private static final String SPACE = " ";

    public static String formMessage(String...strings){
        StringBuilder sb = new StringBuilder();
        for(String str : strings){
            sb.append(str);
            sb.append(SPACE);
        }
        return new String(sb);
    }
}
