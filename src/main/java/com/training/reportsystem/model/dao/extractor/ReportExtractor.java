package com.training.reportsystem.model.dao.extractor;

import com.training.reportsystem.model.dao.mapper.InspectorMapper;
import com.training.reportsystem.model.dao.mapper.TaxPayerMapper;
import com.training.reportsystem.model.dao.util.constant.Columns;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReportExtractor {

    private TaxPayerMapper taxPayerMapper;
    private InspectorMapper inspectorMapper;

    public static Report extract(ResultSet rs) throws SQLException {
        return getBuilder(rs).build();
    }


    public Report extractWithTaxPayer(ResultSet rs) throws SQLException {
        initTaxPayerMapper();
        String userName = rs.getString(Columns.TAX_PAYER_USERNAME);
        return getBuilder(rs).setTaxPayer(taxPayerMapper.map(userName, rs)).build();
    }

    public Report extractWithInspector(ResultSet rs) throws SQLException {
        initInspectorMap();
        String userName = rs.getString(Columns.INSPECTOR_USERNAME);
        return getBuilder(rs).setInspector(inspectorMapper.map(userName, rs)).build();
    }

    private static Report.ReportBuilder getBuilder(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        Status status = Status.valueOf(rs.getString(2).toUpperCase());
        LocalDate periodFrom = LocalDate.parse(rs.getString(3));
        LocalDate periodTo = LocalDate.parse(rs.getString(4));
        Long revenue = rs.getLong(5);
        Double tax = rs.getDouble(6);
        String commentary = rs.getString(7);
        String rejectReason = rs.getString(8);
        LocalDateTime submissionDate = rs.getTimestamp(9).toLocalDateTime();
        LocalDateTime editionDate = rs.getTimestamp(10) == null ? null : rs.getTimestamp(10).toLocalDateTime();
        return new Report.ReportBuilder().setId(id).setStatus(status).setPeriodFrom(periodFrom)
                .setPeriodTo(periodTo).setRevenue(revenue).setTax(tax).setCommentary(commentary)
                .setRejectReason(rejectReason).setSubmissionDate(submissionDate)
                .setEditionDate(editionDate);
    }

    private void initTaxPayerMapper() {
        if (taxPayerMapper == null) {
            taxPayerMapper = new TaxPayerMapper();
        }
    }

    private void initInspectorMap() {
        if (inspectorMapper == null) {
            inspectorMapper = new InspectorMapper();
        }
    }
}
