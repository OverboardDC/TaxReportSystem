package com.training.reportsystem.entity.user;

import com.training.reportsystem.entity.report.Report;

import java.util.List;

public class TaxPayer extends User{

    private List<Request> requests;
    private List<Report> reports;
    private Inspector inspector;

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "requests=" + requests +
                ", reports=" + reports +
                ", inspector=" + inspector +
                "} " + super.toString();
    }

    public static class GenericTaxPayerBuilder<T> extends GenericUserBuilder<T> {

        private final Class<T> builderClass;
        protected List<Request> requests;
        protected List<Report> reports;
        protected Inspector inspector;

        public GenericTaxPayerBuilder(Class<T> builderClass) {
            super(builderClass);
            this.builderClass = builderClass;
        }

        public T setRequests(List<Request> requests) {
            this.requests = requests;
            return builderClass.cast(this);
        }

        public T setReports(List<Report> reports) {
            this.reports = reports;
            return builderClass.cast(this);
        }

        public T setInspector(Inspector inspector) {
            this.inspector = inspector;
            return builderClass.cast(this);
        }

        @Override
        public TaxPayer build(){
            TaxPayer taxPayer = new TaxPayer();
            taxPayer.setId(id);
            taxPayer.setUsername(username);
            taxPayer.setPassword(password);
            taxPayer.setRequests(requests);
            taxPayer.setReports(reports);
            taxPayer.setInspector(inspector);
            return taxPayer;
        }
    }

    public static final class TaxPayerBuilder extends GenericTaxPayerBuilder<TaxPayer>{

        public TaxPayerBuilder() {
            super(TaxPayer.class);
        }
    }
}
