package com.training.reportsystem.model.service.factory;

import com.training.reportsystem.model.service.*;
import com.training.reportsystem.model.service.impl.hibernate.*;

public class ServiceFactory {

    public InspectorService createInspectorService(){
        return new InspectorServiceHibernate();
    }

    public ReportService createReportService(){
        return new ReportServiceHibernate();
    }

    public RequestService createRequestService(){
        return new RequestServiceHibernate();
    }

    public UserService createUserService() {
        return new UserServiceHibernate();
    }

    public TaxPayerService createTaxPayerService(){
        return new TaxPayerServiceHibernate();
    }

}
