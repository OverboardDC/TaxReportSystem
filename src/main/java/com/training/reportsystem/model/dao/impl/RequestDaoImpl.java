package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.user.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RequestDaoImpl implements RequestDao {

    @Override
    public List<Request> findAll() {
        return null;
    }

    @Override
    public Request getById(Long id) {
        return null;
    }

    @Override
    public void create(Request request) {
        try(Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_REQUEST))){

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
