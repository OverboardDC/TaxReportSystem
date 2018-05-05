package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InspectorDaoImpl implements InspectorDao {

    @Override
    public Inspector login(String username, String password) {
        try(Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.INSPECTOR_LOGIN))) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return extractFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Inspector extractFromResultSet(ResultSet rs) throws SQLException {
        Inspector inspector = null;
        while (rs.next()){
            Long id = rs.getLong(1);
            Role role =  Role.valueOf(rs.getString(2).toUpperCase());
            String username = rs.getString(3);
            String password = rs.getString(4);
            String firstName = rs.getString(5);
            String lastName = rs.getString(6);
            inspector = new Inspector.InspectorBuilder().setId(id).setRole(role).setUsername(username).setPassword(password)
                    .setFirstName(firstName).setLastName(lastName).build();
        }
        return inspector;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return false;
    }

    @Override
    public List<Inspector> findAll() {
        return null;
    }

    @Override
    public Inspector getById(Long id) {
        return null;
    }

    @Override
    public void create(Inspector inspector) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
