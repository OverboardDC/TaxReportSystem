package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.mapper.Mapper;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.PaginationDaoUtil;
import com.training.reportsystem.model.dao.util.constant.Columns;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

    @Override
    public List<Request> findAll() {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_REQUESTS))) {

            ResultSet rs = preparedStatement.executeQuery();
            Mapper<Inspector> inspectorMapper = new Mapper<>();
            Mapper<TaxPayer> taxPayerMapper = new Mapper<>();
            while (rs.next()) {
                requests.add(extractRequest(rs, inspectorMapper, taxPayerMapper));
            }

        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public Request getById(Long id) {
        Request request = null;
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.GET_REQUEST_BY_ID))) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                request = extractLazyRequest(rs);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return request;
    }

    @Override
    public void create(Request request) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_REQUEST));

            preparedStatement.setLong(1, request.getTaxPayer().getId());
            preparedStatement.setLong(2, request.getInspector().getId());
            preparedStatement.setString(3, request.getReason());
            preparedStatement.setString(4, String.valueOf(request.getStatus()));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(request.getSubmissionDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void update(Request request) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.UPDATE_REQUEST));

            preparedStatement.setLong(1, request.getTaxPayer().getId());
            preparedStatement.setLong(2, request.getInspector().getId());
            preparedStatement.setString(3, request.getReason());
            preparedStatement.setString(4, String.valueOf(request.getStatus()));
            preparedStatement.setLong(5, request.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.DELETE_REQUEST));
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId, Pagination pagination) {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            String query = DaoUtil.getQuery(Queries.FIND_REQUESTS_BY_TAX_PAYER);
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection,
                    DaoUtil.getQuery(Queries.GET_COUNT_ALL_REQUESTS_BY_TAX_PAYER), taxPayerId));
            PreparedStatement preparedStatement = connection.prepareStatement(PaginationDaoUtil.formQueryWithPagination(query, pagination));

            preparedStatement.setLong(1, taxPayerId);
            ResultSet rs = preparedStatement.executeQuery();
            Mapper<Inspector> inspectorMapper = new Mapper<>();
            Mapper<TaxPayer> taxPayerMapper = new Mapper<>();
            while (rs.next()) {
                requests.add(extractRequest(rs, inspectorMapper, taxPayerMapper));
            }

        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public List<Request> findByStatus(Status status, Pagination pagination) {
        List<Request> requests = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            String query = DaoUtil.getQuery(Queries.FIND_ALL_REQUESTS_BY_STATUS);
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection,
                    DaoUtil.getQuery(Queries.GET_COUNT_ALL_REQUESTS_BY_STATUS), status));
            PreparedStatement preparedStatement = connection.prepareStatement(PaginationDaoUtil.formQueryWithPagination(query, pagination));

            preparedStatement.setString(1, status.toString());
            ResultSet rs = preparedStatement.executeQuery();
            Mapper<Inspector> inspectorMapper = new Mapper<>();
            Mapper<TaxPayer> taxPayerMapper = new Mapper<>();
            while (rs.next()) {
                requests.add(extractRequest(rs, inspectorMapper, taxPayerMapper));
            }

        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return requests;
    }

    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            connection.setAutoCommit(false);

            try {
                PreparedStatement prstAccept = connection.prepareStatement(DaoUtil.getQuery(Queries.ACCEPT_REQUEST));
                prstAccept.setString(1, Status.APPROVED.toString());
                prstAccept.setLong(2, requestId);
                prstAccept.executeUpdate();

                PreparedStatement prstAssignInspector = connection.prepareStatement(DaoUtil.getQuery(Queries.ASSIGN_INSPECTOR));
                prstAssignInspector.setLong(1, inspectorId);
                prstAssignInspector.setLong(2, taxPayerId);
                prstAssignInspector.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                logger.error(LoggerMessages.SQL_EXCEPTION);
                e.printStackTrace();
            }
            connection.setAutoCommit(true);
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

    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.ARE_THERE_REQUESTS_STATUS))) {
            preparedStatement.setLong(1, taxPayerId);
            preparedStatement.setString(2, status.toString());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return false;
    }

    private Request extractLazyRequest(ResultSet rs) throws SQLException {
        return getBuilder(rs).build();
    }

    private Request extractRequest(ResultSet rs, Mapper<Inspector> inspectorMapper, Mapper<TaxPayer> taxPayerMapper) throws SQLException {
        String inspectorUserName = rs.getString(Columns.INSPECTOR_USERNAME);
        if (!inspectorMapper.getMap().containsKey(inspectorUserName)) {
            inspectorMapper.getMap().put(inspectorUserName, extractInspectorFromRs(rs));
        }
        String taxPayerUserName = rs.getString(Columns.TAX_PAYER_USERNAME);
        if (!taxPayerMapper.getMap().containsKey(taxPayerUserName)) {
            taxPayerMapper.getMap().put(taxPayerUserName, extractTaxPayerFromRs(rs));
        }
        return getBuilder(rs).setInspector(inspectorMapper.get(inspectorUserName))
                .setTaxPayer(taxPayerMapper.get(taxPayerUserName)).build();
    }

    private Request.RequestBuilder getBuilder(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String reason = rs.getString(4);
        Status status = Status.valueOf(rs.getString(5).toUpperCase());
        String rejectReason = rs.getString(6);
        LocalDateTime submissionDate = rs.getTimestamp(7).toLocalDateTime();
        return new Request.RequestBuilder().setId(id).setReason(reason)
                .setStatus(status).setRejectReason(rejectReason).setSubmissionDate(submissionDate);
    }

    private Inspector extractInspectorFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong(Columns.INSPECTOR_ID);
        String firstName = rs.getString(Columns.INSPECTOR_FIRST_NAME);
        String lastName = rs.getString(Columns.INSPECTOR_LAST_NAME);
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }

    private TaxPayer extractTaxPayerFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong(Columns.TAX_PAYER_ID);
        String firstName = rs.getString(Columns.TAX_PAYER_FIRST_NAME);
        String lastName = rs.getString(Columns.TAX_PAYER_LAST_NAME);
        String username = rs.getString(Columns.TAX_PAYER_USERNAME);
        String identificationCode = rs.getString(Columns.TAX_PAYER_IDENTIFICATION_CODE);
        return new TaxPayer.TaxPayerBuilder().setId(id).setFirstName(firstName)
                .setLastName(lastName).setUsername(username)
                .setIdentificationCode(identificationCode).build();
    }
}
