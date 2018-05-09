package com.training.reportsystem.util;

public class LoggerUtil {

    public static String formMessage(String...strings){
        StringBuilder sb = new StringBuilder();
        for(String str : strings){
            sb.append(str);
            sb.append(" ");
        }
        return new String(sb);
    }
}
