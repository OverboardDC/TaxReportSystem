package com.training.reportsystem.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "taxpayer_id")
    private TaxPayer taxPayer;

    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private Inspector inspector;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String reason;

    @Column(name = "reject_reason")
    private String rejectReason;

    @Column(name = "submission_date")
    private LocalDateTime submissionDate;

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

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public LocalDateTime getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDateTime submissionDate) {
        this.submissionDate = submissionDate;
    }

    public static final class RequestBuilder implements Builder<Request> {

        private Long id;
        private TaxPayer taxPayer;
        private Inspector inspector;
        private Status status;
        private String reason;
        private String rejectReason;
        private LocalDateTime submissionDate;

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

        public RequestBuilder setRejectReason(String rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public RequestBuilder setSubmissionDate(LocalDateTime submissionDate) {
            this.submissionDate = submissionDate;
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
            request.setRejectReason(rejectReason);
            request.setSubmissionDate(submissionDate);
            return request;
        }
    }
}
