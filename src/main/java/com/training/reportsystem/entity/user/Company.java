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

    public abstract static class GenericCompanyBuilder<T extends GenericCompanyBuilder<T>> extends GenericTaxPayerBuilder<T> {

        private final Class<T> builderClass;
        private String name;

        public GenericCompanyBuilder(Class<T> builderClass) {
            super(builderClass);
            this.builderClass = builderClass;
        }

        public T setName(String name) {
            this.name = name;
            return builderClass.cast(this);
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

    public static final class CompanyBuilder extends GenericCompanyBuilder<CompanyBuilder> {

        public CompanyBuilder() {
            super(CompanyBuilder.class);
        }

    }
}
