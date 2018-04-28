package com.training.reportsystem.entity.report;

import com.training.reportsystem.entity.Builder;

public class Revenue {

    private Long id;
    private RevenueSource revenueSource;
    private Report report;
    private Long sum;
    private double tax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RevenueSource getRevenueSource() {
        return revenueSource;
    }

    public void setRevenueSource(RevenueSource revenueSource) {
        this.revenueSource = revenueSource;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "id=" + id +
                ", revenueSource=" + revenueSource +
                ", report=" + report +
                ", sum=" + sum +
                ", tax=" + tax +
                '}';
    }

    public static final class RevenueBuilder implements Builder<Revenue> {

        private Long id;
        private RevenueSource revenueSource;
        private Report report;
        private Long sum;
        private double tax;

        public RevenueBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public RevenueBuilder setRevenueSource(RevenueSource revenueSource) {
            this.revenueSource = revenueSource;
            return this;
        }

        public RevenueBuilder setReport(Report report) {
            this.report = report;
            return this;
        }

        public RevenueBuilder setSum(Long sum) {
            this.sum = sum;
            return this;
        }

        public RevenueBuilder setTax(double tax) {
            this.tax = tax;
            return this;
        }

        @Override
        public Revenue build() {
            Revenue revenue = new Revenue();
            revenue.setId(id);
            revenue.setRevenueSource(revenueSource);
            revenue.setReport(report);
            revenue.setSum(sum);
            revenue.setTax(tax);
            return revenue;
        }
    }
}
