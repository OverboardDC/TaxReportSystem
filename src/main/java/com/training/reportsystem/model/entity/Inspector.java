package com.training.reportsystem.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inspector")
public class Inspector extends User {

    @OneToMany(mappedBy = "inspector", cascade = CascadeType.ALL)
    private List<TaxPayer> taxPayers;

    @OneToMany(mappedBy = "inspector")
    private List<Report> reports;

    @OneToMany(mappedBy = "inspector")
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
