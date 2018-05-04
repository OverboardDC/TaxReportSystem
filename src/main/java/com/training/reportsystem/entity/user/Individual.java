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



    public static abstract class GenericIndividualBuilder<T extends GenericIndividualBuilder<T>> extends GenericTaxPayerBuilder<T>{

        private final Class<T> builderClass;
        private String firstName;
        private String lastName;
        private String identificationCode;

        public GenericIndividualBuilder(Class<T> builderClass) {
            super(builderClass);
            this.builderClass = builderClass;
        }

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return builderClass.cast(this);
        }

        public T setLastName(String lastName) {
            this.lastName = lastName;
            return builderClass.cast(this);
        }

        public T setIdentificationCode(String identificationCode) {
            this.identificationCode = identificationCode;
            return builderClass.cast(this);
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

    public static final class IndividualBuilder extends GenericIndividualBuilder<IndividualBuilder> {

        public IndividualBuilder() {
            super(IndividualBuilder.class);
        }
    }
}
