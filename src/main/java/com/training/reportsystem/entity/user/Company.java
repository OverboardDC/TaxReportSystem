package com.training.reportsystem.entity.user;

public class Company extends TaxPayer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }

    public static final class CompanyBuilder extends GenericTaxPayerBuilder<CompanyBuilder> {

        private String name;

        public CompanyBuilder() {
            super(CompanyBuilder.class);
        }

        public CompanyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public Company build() {
            Company company = new Company();
            company.setId(id);
            company.setUsername(username);
            company.setPassword(password);
            company.setRequests(requests);
            company.setReports(reports);
            company.setInspector(inspector);
            company.setName(name);
            return company;
        }
    }
}
