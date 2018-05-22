package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.extractor.ReportExtractor;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.PaginationDaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.*;
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
               reports.add(ReportExtractor.extract(rs));
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
                report = ReportExtractor.extract(rs);
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
            ReportExtractor reportExtractor = new ReportExtractor();
            while (rs.next()) {
                reports.add(reportExtractor.extractWithInspector(rs));
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
            ReportExtractor reportExtractor = new ReportExtractor();
            while (rs.next()) {
                reports.add(reportExtractor.extractWithTaxPayer(rs));
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


}
