package com.training.reportsystem.model.dao.extractor;

import com.training.reportsystem.model.dao.mapper.InspectorMapper;
import com.training.reportsystem.model.dao.mapper.TaxPayerMapper;
import com.training.reportsystem.model.dao.util.constant.Columns;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RequestExtractor {

    private TaxPayerMapper taxPayerMapper = new TaxPayerMapper();
    private InspectorMapper inspectorMapper = new InspectorMapper();

    public static Request extractLazy(ResultSet rs) throws SQLException {
        return getBuilder(rs).build();
    }

    public Request extract(ResultSet rs) throws SQLException {
        String inspectorUserName = rs.getString(Columns.INSPECTOR_USERNAME);
        String taxPayerUserName = rs.getString(Columns.TAX_PAYER_USERNAME);
        return getBuilder(rs).setInspector(inspectorMapper.map(inspectorUserName, rs))
                .setTaxPayer(taxPayerMapper.map(taxPayerUserName, rs)).build();
    }

    private static Request.RequestBuilder getBuilder(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String reason = rs.getString(4);
        Status status = Status.valueOf(rs.getString(5).toUpperCase());
        String rejectReason = rs.getString(6);
        LocalDateTime submissionDate = rs.getTimestamp(7).toLocalDateTime();
        return new Request.RequestBuilder().setId(id).setReason(reason)
                .setStatus(status).setRejectReason(rejectReason).setSubmissionDate(submissionDate);
    }
}
