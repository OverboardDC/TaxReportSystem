package com.training.reportsystem.entity.report;

import com.training.reportsystem.entity.Builder;

import java.util.List;

public class RevenueSource {

    private Long id;
    private String name;
    private List<Revenue> revenues;
    private List<ReportType> reportTypes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Revenue> getRevenues() {
        return revenues;
    }

    public void setRevenues(List<Revenue> revenues) {
        this.revenues = revenues;
    }

    public List<ReportType> getReportTypes() {
        return reportTypes;
    }

    public void setReportTypes(List<ReportType> reportTypes) {
        this.reportTypes = reportTypes;
    }

    @Override
    public String toString() {
        return "RevenueSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", revenues=" + revenues +
                ", reportTypes=" + reportTypes +
                '}';
    }

    public static final class RevenueSourceBuilder implements Builder<RevenueSource> {

        private Long id;
        private String name;
        private List<Revenue> revenues;
        private List<ReportType> reportTypes;

        public RevenueSourceBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public RevenueSourceBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public RevenueSourceBuilder setRevenues(List<Revenue> revenues) {
            this.revenues = revenues;
            return this;
        }

        public RevenueSourceBuilder setReportTypes(List<ReportType> reportTypes) {
            this.reportTypes = reportTypes;
            return this;
        }

        @Override
        public RevenueSource build() {
            RevenueSource revenueSource = new RevenueSource();
            revenueSource.setId(id);
            revenueSource.setName(name);
            revenueSource.setRevenues(revenues);
            revenueSource.setReportTypes(reportTypes);
            return revenueSource;
        }
    }
}
