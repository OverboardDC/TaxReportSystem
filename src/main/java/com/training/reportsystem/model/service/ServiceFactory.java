package com.training.reportsystem.model.service;

import com.training.reportsystem.model.service.impl.InspectorServiceImpl;
import com.training.reportsystem.model.service.impl.ReportServiceImpl;
import com.training.reportsystem.model.service.impl.RequestServiceImpl;
import com.training.reportsystem.model.service.impl.TaxPayerServiceImpl;

public class ServiceFactory {

    private static class InstanceHolder {
        public static final ServiceFactory instance = new ServiceFactory();
    }

    public InspectorService createInspectorService(){
        return new InspectorServiceImpl();
    }

    public ReportService createReportService(){
        return new ReportServiceImpl();
    }

    public RequestService createRequestService(){
        return new RequestServiceImpl();
    }

    public TaxPayerService createTaxPayerService(){
        return new TaxPayerServiceImpl();
    }

    public static ServiceFactory getInstance(){
        return InstanceHolder.instance;
    }
}
