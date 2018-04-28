package com.training.reportsystem.entity.user;

public class Individual extends TaxPayer implements Person {

    private String firstName;
    private String lastName;
    private String identificationCode;

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

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    @Override
    public String toString() {
        return "Individual{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", identificationCode='" + identificationCode + '\'' +
                "} " + super.toString();
    }

    public static final class IndividualBuilder extends GenericTaxPayerBuilder<IndividualBuilder>{

        private String firstName;
        private String lastName;
        private String identificationCode;

        public IndividualBuilder() {
            super(IndividualBuilder.class);
        }

        public IndividualBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public IndividualBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public IndividualBuilder setIdentificationCode(String identificationCode) {
            this.identificationCode = identificationCode;
            return this;
        }

        @Override
        public Individual build() {
            Individual individual = new Individual();
            individual.setId(id);
            individual.setUsername(username);
            individual.setPassword(password);
            individual.setRequests(requests);
            individual.setReports(reports);
            individual.setInspector(inspector);
            individual.setFirstName(firstName);
            individual.setLastName(lastName);
            individual.setIdentificationCode(identificationCode);
            return individual;
        }
    }
}
