package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Report;

import java.sql.*;
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
            e.printStackTrace();
        }
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
