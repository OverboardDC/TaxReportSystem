package com.training.reportsystem.entity.user;

import com.training.reportsystem.entity.report.Report;

import java.util.List;

public class Inspector extends User implements Person {

    private Role role;
    private List<TaxPayer> taxPayers;
    private List<Report> reports;
    private List<Request> requests;
    private String firstName;
    private String lastName;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "role=" + role +
                ", taxPayers=" + taxPayers +
                ", reports=" + reports +
                ", requests=" + requests +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "} " + super.toString();
    }

    public static class InspectorBuilder extends GenericUserBuilder<InspectorBuilder> {

        private Role role;
        private List<TaxPayer> taxPayers;
        private List<Report> reports;
        private List<Request> requests;
        private String firstName;
        private String lastName;

        public InspectorBuilder() {
            super(InspectorBuilder.class);
        }

        public InspectorBuilder setRole(Role role) {
            this.role = role;
            return this;
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

        public InspectorBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public InspectorBuilder setLastName(String lastName) {
            this.lastName = lastName;
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
