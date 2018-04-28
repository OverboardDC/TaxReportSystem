package com.training.reportsystem.entity.user;

import com.training.reportsystem.entity.Builder;
import com.training.reportsystem.entity.report.Status;

public class Request {

    private Long id;
    private TaxPayer taxPayer;
    private Inspector inspector;
    private Status status;
    private String reason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaxPayer getTaxPayer() {
        return taxPayer;
    }

    public void setTaxPayer(TaxPayer taxPayer) {
        this.taxPayer = taxPayer;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public static final class RequestBuilder implements Builder<Request> {

        private Long id;
        private TaxPayer taxPayer;
        private Inspector inspector;
        private Status status;
        private String reason;

        public RequestBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public RequestBuilder setTaxPayer(TaxPayer taxPayer) {
            this.taxPayer = taxPayer;
            return this;
        }

        public RequestBuilder setInspector(Inspector inspector) {
            this.inspector = inspector;
            return this;
        }

        public RequestBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public RequestBuilder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        @Override
        public Request build() {
            Request request = new Request();
            request.setId(id);
            request.setTaxPayer(taxPayer);
            request.setInspector(inspector);
            request.setStatus(status);
            request.setReason(reason);
            return request;
        }
    }
}
