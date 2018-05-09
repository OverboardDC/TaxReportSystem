package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Role;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//TODO create mappers!
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
            logger.error(LoggerMessages.SQL_EXCEPTION);
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
    //TODO Temporary
    public List<Inspector> findAll() {
        List<Inspector> inspectors = new ArrayList<>();
        try(Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_INSPECTORS))) {
            preparedStatement.setString(1, Role.INSPECTOR.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                inspectors.add(buildLazyFromRs(rs));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return inspectors;
    }

    @Override
    public Inspector getById(Long id) {
        return null;
    }

    private Inspector buildLazyFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
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

    @Override
    public Inspector getByUserId(Long userId) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.GET_INSPECTOR_BY_USER))) {

            preparedStatement.setLong(1, userId);

            ResultSet rs = preparedStatement.executeQuery();
            Inspector inspector = null;
            while (rs.next()){
                inspector = buildLazyFromRs(rs);
            }
            return inspector;
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return null;
    }
}
