package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.Request;
import com.training.reportsystem.model.entity.user.TaxPayer;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

    @Override
    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_REQUESTS))) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                requests.add(extractRequestFromRs(rs));
            }

        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public Request getById(Long id) {
        return null;
    }

    @Override
    public void create(Request request) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_REQUEST));

            preparedStatement.setLong(1, request.getTaxPayer().getId());
            preparedStatement.setLong(2, request.getInspector().getId());
            preparedStatement.setString(3, request.getReason());
            preparedStatement.setString(4, String.valueOf(request.getStatus()));

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
    public List<Request> findByTaxPayerId(Long taxPayerId) {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_REQUESTS_BY_TAX_PAYER))) {

            preparedStatement.setLong(1, taxPayerId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                requests.add(extractRequestFromRs(rs));
            }

        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public List<Request> findByStatus(Status status) {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_REQUESTS_BY_STATUS))) {

            preparedStatement.setString(1, status.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                requests.add(extractRequestFromRs(rs));
            }

        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public void accept(Long requestId) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.ACCEPT_REQUEST))) {

            preparedStatement.setString(1, Status.APPROVED.toString());
            preparedStatement.setLong(2, requestId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void reject(Long requestId, String rejectReason) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.REJECT_REQUEST))) {

            preparedStatement.setString(1, Status.REJECTED.toString());
            preparedStatement.setString(2, rejectReason);
            preparedStatement.setLong(3, requestId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    private Request extractRequestFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String reason = rs.getString(4);
        Status status = Status.valueOf(rs.getString(5).toUpperCase());
        String rejectReason = rs.getString(6);
        return new Request.RequestBuilder().setId(id).setReason(reason)
                .setStatus(status).setRejectReason(rejectReason).setTaxPayer(extractTaxPayerFromRs(rs))
                .setInspector(extractInspectorFromRs(rs)).build();
    }

    private Inspector extractInspectorFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong("i.id");
        String firstName = rs.getString("i.firstname");
        String lastName = rs.getString("i.lastname");
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }

    private TaxPayer extractTaxPayerFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong("t.id");
        String firstName = rs.getString("t.firstname");
        String lastName = rs.getString("t.lastname");
        String username = rs.getString("t.username");
        String identificationCode = rs.getString("t.identification_code");
        return new TaxPayer.TaxPayerBuilder().setId(id).setFirstName(firstName)
                .setLastName(lastName).setUsername(username)
                .setIdentificationCode(identificationCode).build();
    }
}
