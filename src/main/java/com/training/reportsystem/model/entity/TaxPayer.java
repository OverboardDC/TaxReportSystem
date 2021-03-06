package com.training.reportsystem.model.entity;

import java.util.List;

public class TaxPayer extends User{

    private List<Request> requests;
    private List<Report> reports;
    private Inspector inspector;
    private String identificationCode;

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

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "requests=" + requests +
                ", reports=" + reports +
                ", inspector=" + inspector +
                ", identificationCode='" + identificationCode + '\'' +
                "} " + super.toString();
    }

    public static class TaxPayerBuilder extends GenericUserBuilder<TaxPayerBuilder> {

        protected List<Request> requests;
        protected List<Report> reports;
        protected Inspector inspector;
        protected String identificationCode;

        public TaxPayerBuilder() {
            super(TaxPayerBuilder.class);
        }

        public TaxPayerBuilder setRequests(List<Request> requests) {
            this.requests = requests;
            return this;
        }

        public TaxPayerBuilder setReports(List<Report> reports) {
            this.reports = reports;
            return this;
        }

        public TaxPayerBuilder setInspector(Inspector inspector) {
            this.inspector = inspector;
            return this;
        }


        public TaxPayerBuilder setIdentificationCode(String identificationCode) {
            this.identificationCode = identificationCode;
            return this;
        }

        @Override
        public TaxPayer build(){
            TaxPayer taxPayer = new TaxPayer();
            taxPayer.setId(id);
            taxPayer.setUsername(username);
            taxPayer.setPassword(password);
            taxPayer.setRole(role);
            taxPayer.setRequests(requests);
            taxPayer.setReports(reports);
            taxPayer.setInspector(inspector);
            taxPayer.setFirstName(firstName);
            taxPayer.setLastName(lastName);
            taxPayer.setIdentificationCode(identificationCode);
            return taxPayer;
        }
    }
}
