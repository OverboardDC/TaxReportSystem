package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {

    @Override
    public List<Report> findAll() {
        return null;
    }

    @Override
    public Report getById(Long id) {
        return null;
    }

    @Override
    public void create(Report report) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_REPORT))) {

            preparedStatement.setLong(1, report.getTaxPayer().getId());
            preparedStatement.setLong(2, report.getInspector().getId());
            preparedStatement.setString(3, report.getStatus().toString());
            preparedStatement.setDate(4, Date.valueOf(report.getPeriodFrom()));
            preparedStatement.setDate(5, Date.valueOf(report.getPeriodTo()));
            preparedStatement.setLong(6, report.getRevenue());
            preparedStatement.setDouble(7, report.getTax());
            preparedStatement.setString(8, report.getCommentary());
            preparedStatement.setTimestamp(9, Timestamp.valueOf(report.getSubmissionDate()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Report> findAllByUser(Long userId) {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_REPORTS_BY_USER))) {

            preparedStatement.setLong(1, userId);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                reports.add(extractFromRs(rs));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return reports;
    }

    private Report extractFromRs(ResultSet rs) throws SQLException {
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
                .setEditionDate(editionDate).setInspector(extractInspector(rs)).build();
    }

    private Inspector extractInspector(ResultSet rs) throws SQLException {
        Long id = rs.getLong("i.id");
        String firstName = rs.getString("i.firstname");
        String lastName = rs.getString("i.lastname");
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }
}
