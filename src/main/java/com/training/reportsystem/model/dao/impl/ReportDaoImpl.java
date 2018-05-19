package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.mapper.Mapper;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.PaginationDaoUtil;
import com.training.reportsystem.model.dao.util.constant.Columns;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReportDaoImpl implements ReportDao {

    @Override
    public List<Report> findAll() {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_REPORTS))) {

           ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()){
               reports.add(extractLazyFromRs(rs));
           }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return reports;
    }

    @Override
    public Report getById(Long id) {
        Report report = null;
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.GET_REPORT_BY_ID))) {
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                report = getBuilder(rs).build();
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return report;
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
    public void update(Report report) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.UPDATE_REPORT))) {

            preparedStatement.setString(1, Status.PENDING.toString());
            preparedStatement.setDate(2, Date.valueOf(report.getPeriodFrom()));
            preparedStatement.setDate(3, Date.valueOf(report.getPeriodTo()));
            preparedStatement.setLong(4, report.getRevenue());
            preparedStatement.setDouble(5, report.getTax());
            preparedStatement.setString(6, report.getCommentary());
            preparedStatement.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setLong(8, report.getInspector().getId());
            preparedStatement.setLong(9, report.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.DELETE_REPORT))) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public List<Report> findAllByUser(Long userId, Pagination pagination) {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            String query = DaoUtil.getQuery(Queries.FIND_ALL_REPORTS_BY_USER);
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection,
                    DaoUtil.getQuery(Queries.GET_COUNT_ALL_REPORTS_BY_USER), userId));
            PreparedStatement preparedStatement = connection.prepareStatement(PaginationDaoUtil.formQueryWithPagination(query, pagination));

            preparedStatement.setLong(1, userId);

            ResultSet rs = preparedStatement.executeQuery();
            Mapper<Inspector> mapper = new Mapper<>();
            while (rs.next()) {
                reports.add(extractFromRsWithInspector(rs, mapper));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return reports;
    }

    @Override
    public List<Report> findAllByInspector(Long inspectorId, Pagination pagination) {
        List<Report> reports = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            String query = DaoUtil.getQuery(Queries.FIND_ALL_REPORTS_BY_INSPECTOR);
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection,
                    DaoUtil.getQuery(Queries.GET_COUNT_ALL_REPORTS_BY_INSPECTOR), inspectorId));
            PreparedStatement preparedStatement = connection.prepareStatement(PaginationDaoUtil.formQueryWithPagination(query, pagination));

            preparedStatement.setLong(1, inspectorId);

            ResultSet rs = preparedStatement.executeQuery();
            Mapper<TaxPayer> mapper = new Mapper<>();
            while (rs.next()) {
                reports.add(extractFromRsWithTaxPayer(rs, mapper));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return reports;
    }

    @Override
    public void approveReport(Long reportId) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.APPROVE_REPORT))) {

            preparedStatement.setString(1, Status.APPROVED.toString());
            preparedStatement.setLong(2, reportId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.REJECT_REPORT))) {

            preparedStatement.setString(1, Status.REJECTED.toString());
            preparedStatement.setString(2, rejectReason);
            preparedStatement.setLong(3, reportId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    private Report extractLazyFromRs(ResultSet rs) throws SQLException {
        return getBuilder(rs).build();
    }

    private Report extractFromRsWithTaxPayer(ResultSet rs, Mapper<TaxPayer> mapper) throws SQLException {
        String userName = rs.getString(Columns.TAX_PAYER_USERNAME);
        if (!mapper.getMap().containsKey(userName)) {
            mapper.getMap().put(userName, extractTaxPayer(rs));
        }
        return getBuilder(rs).setTaxPayer(mapper.get(userName)).build();
    }

    private Report extractFromRsWithInspector(ResultSet rs, Mapper<Inspector> mapper) throws SQLException {
        String userName = rs.getString(Columns.INSPECTOR_USERNAME);
        if (!mapper.getMap().containsKey(userName)) {
            mapper.getMap().put(userName, extractInspector(rs));
        }
        return getBuilder(rs).setInspector(mapper.get(userName)).build();
    }

    private Report.ReportBuilder getBuilder(ResultSet rs) throws SQLException {
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

    private Inspector extractInspector(ResultSet rs) throws SQLException {
        Long id = rs.getLong(Columns.INSPECTOR_ID);
        String firstName = rs.getString(Columns.INSPECTOR_FIRST_NAME);
        String lastName = rs.getString(Columns.INSPECTOR_LAST_NAME);
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }

    private TaxPayer extractTaxPayer(ResultSet rs) throws SQLException {
        Long id = rs.getLong(Columns.TAX_PAYER_ID);
        String firstName = rs.getString(Columns.TAX_PAYER_FIRST_NAME);
        String lastName = rs.getString(Columns.TAX_PAYER_LAST_NAME);
        return new TaxPayer.TaxPayerBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }
}
