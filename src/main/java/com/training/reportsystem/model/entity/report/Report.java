package com.training.reportsystem.model.entity.report;

import com.training.reportsystem.model.entity.Builder;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.TaxPayer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Report {

    private Long id;
    private TaxPayer taxPayer;
    private Inspector inspector;
    private ReportType reportType;
    private List<Revenue> revenues;
    private Status status;
    private LocalDate periodFrom;
    private LocalDate periodTo;
    private String message;
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

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public List<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenues(List<Revenue> revenues) {
        this.revenues = revenues;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
                ", reportType=" + reportType +
                ", revenues=" + revenues +
                ", status=" + status +
                ", periodFrom=" + periodFrom +
                ", periodTo=" + periodTo +
                ", message='" + message + '\'' +
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
        private ReportType reportType;
        private List<Revenue> revenues;
        private Status status;
        private LocalDate periodFrom;
        private LocalDate periodTo;
        private String message;
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

        public ReportBuilder setReportType(ReportType reportType) {
            this.reportType = reportType;
            return this;
        }

        public ReportBuilder setRevenues(List<Revenue> revenues) {
            this.revenues = revenues;
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

        public ReportBuilder setMessage(String message) {
            this.message = message;
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
            report.setReportType(reportType);
            report.setRevenues(revenues);
            report.setStatus(status);
            report.setPeriodFrom(periodFrom);
            report.setPeriodTo(periodTo);
            report.setMessage(message);
            report.setCommentary(commentary);
            report.setRejectReason(rejectReason);
            report.setSubmissionDate(submissionDate);
            report.setEditionDate(editionDate);
            return report;
        }
    }
}
