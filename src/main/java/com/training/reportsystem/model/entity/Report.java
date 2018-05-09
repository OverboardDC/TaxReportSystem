package com.training.reportsystem.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Report {

    private Long id;
    private TaxPayer taxPayer;
    private Inspector inspector;
    private Status status;
    private LocalDate periodFrom;
    private LocalDate periodTo;
    private String commentary;
    private String rejectReason;
    private LocalDateTime submissionDate;
    private LocalDateTime editionDate;

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

    public LocalDate getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(LocalDate periodFrom) {
        this.periodFrom = periodFrom;
    }

    public LocalDate getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(LocalDate periodTo) {
        this.periodTo = periodTo;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
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

    public LocalDateTime getEditionDate() {
        return editionDate;
    }

    public void setEditionDate(LocalDateTime editionDate) {
        this.editionDate = editionDate;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", taxPayer=" + taxPayer +
                ", inspector=" + inspector +
                ", status=" + status +
                ", periodFrom=" + periodFrom +
                ", periodTo=" + periodTo +
                ", commentary='" + commentary + '\'' +
                ", rejectReason='" + rejectReason + '\'' +
                ", submissionDate=" + submissionDate +
                ", editionDate=" + editionDate +
                '}';
    }

    public static final class ReportBuilder implements Builder<Report> {

        private Long id;
        private TaxPayer taxPayer;
        private Inspector inspector;
        private Status status;
        private LocalDate periodFrom;
        private LocalDate periodTo;
        private String commentary;
        private String rejectReason;
        private LocalDateTime submissionDate;
        private LocalDateTime editionDate;

        public ReportBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ReportBuilder setTaxPayer(TaxPayer taxPayer) {
            this.taxPayer = taxPayer;
            return this;
        }

        public ReportBuilder setInspector(Inspector inspector) {
            this.inspector = inspector;
            return this;
        }

        public ReportBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public ReportBuilder setPeriodFrom(LocalDate periodFrom) {
            this.periodFrom = periodFrom;
            return this;
        }

        public ReportBuilder setPeriodTo(LocalDate periodTo) {
            this.periodTo = periodTo;
            return this;
        }

        public ReportBuilder setCommentary(String commentary) {
            this.commentary = commentary;
            return this;
        }

        public ReportBuilder setRejectReason(String rejectReason) {
            this.rejectReason = rejectReason;
            return this;
        }

        public ReportBuilder setSubmissionDate(LocalDateTime submissionDate) {
            this.submissionDate = submissionDate;
            return this;
        }

        public ReportBuilder setEditionDate(LocalDateTime editionDate) {
            this.editionDate = editionDate;
            return this;
        }

        @Override
        public Report build() {
            Report report = new Report();
            report.setId(id);
            report.setTaxPayer(taxPayer);
            report.setInspector(inspector);
            report.setStatus(status);
            report.setPeriodFrom(periodFrom);
            report.setPeriodTo(periodTo);
            report.setCommentary(commentary);
            report.setRejectReason(rejectReason);
            report.setSubmissionDate(submissionDate);
            report.setEditionDate(editionDate);
            return report;
        }
    }
}
