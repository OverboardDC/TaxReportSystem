package com.training.reportsystem.model.entity.user;

import com.training.reportsystem.model.entity.report.Report;

import java.util.List;

public class Inspector extends User {

    private List<TaxPayer> taxPayers;
    private List<Report> reports;
    private List<Request> requests;

    public List<TaxPayer> getTaxPayers() {
        return taxPayers;
    }

    public void setTaxPayers(List<TaxPayer> taxPayers) {
        this.taxPayers = taxPayers;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                ", taxPayers=" + taxPayers +
                ", reports=" + reports +
                ", requests=" + requests +
                "} " + super.toString();
    }

    public static class InspectorBuilder extends GenericUserBuilder<InspectorBuilder> {

        private List<TaxPayer> taxPayers;
        private List<Report> reports;
        private List<Request> requests;

        public InspectorBuilder() {
            super(InspectorBuilder.class);
        }


        public InspectorBuilder setTaxPayers(List<TaxPayer> taxPayers) {
            this.taxPayers = taxPayers;
            return this;
        }

        public InspectorBuilder setReports(List<Report> reports) {
            this.reports = reports;
            return this;
        }

        public InspectorBuilder setRequests(List<Request> requests) {
            this.requests = requests;
            return this;
        }

        @Override
        public Inspector build() {
            Inspector inspector = new Inspector();
            inspector.setId(id);
            inspector.setUsername(username);
            inspector.setPassword(password);
            inspector.setRole(role);
            inspector.setTaxPayers(taxPayers);
            inspector.setReports(reports);
            inspector.setRequests(requests);
            inspector.setFirstName(firstName);
            inspector.setLastName(lastName);
            return inspector;
        }
    }
}
