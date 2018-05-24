package com.training.reportsystem.util;

public class ValueParser {

    public static Long parseRevenue(String revenueParam) {
       double sum = Double.parseDouble(revenueParam);
       return Math.round(sum * 100.0);
    }

    public static Double parseTax(String taxParam) {
        return Double.parseDouble(taxParam) / 100;
    }
}
