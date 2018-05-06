package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.Request;
import com.training.reportsystem.model.entity.user.TaxPayer;

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
            while(rs.next()){
                requests.add(extractRequestFromRs(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    private Request extractRequestFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String reason = rs.getString(4);
        Status status = Status.valueOf(rs.getString(5).toUpperCase());
        return new Request.RequestBuilder().setId(id).setReason(reason)
                .setStatus(status).setTaxPayer(extractTaxPayerFromRs(rs))
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

    @Override
    public Request getById(Long id) {
        return null;
    }

    @Override
    public void create(Request request) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_REQUEST))) {

            preparedStatement.setLong(1, request.getTaxPayer().getId());
            preparedStatement.setLong(2, request.getInspector().getId());
            preparedStatement.setString(3, request.getReason());
            preparedStatement.setString(4, String.valueOf(request.getStatus()));

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
