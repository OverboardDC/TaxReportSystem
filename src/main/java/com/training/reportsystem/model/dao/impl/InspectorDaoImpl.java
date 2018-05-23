package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.extractor.InspectorExtractor;
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

public class InspectorDaoImpl implements InspectorDao {

    @Override
    public Inspector login(String username, String password) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.INSPECTOR_LOGIN))) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return InspectorExtractor.extract(rs);
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.IS_INSPECTOR_USERNAME_UNIQUE))) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<Inspector> findAll() {
        List<Inspector> inspectors = new ArrayList<>();
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_INSPECTORS))) {
            preparedStatement.setString(1, Role.INSPECTOR.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                inspectors.add(InspectorExtractor.extractLazy(rs));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return inspectors;
    }

    @Override
    public Inspector getById(Long id) {
        Inspector inspector = null;
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.GET_INSPECTOR_BY_ID))) {

            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                inspector = InspectorExtractor.extractLazy(rs);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return inspector;
    }

    @Override
    public void create(Inspector inspector) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_INSPECTOR))) {
            preparedStatement.setString(1, inspector.getRole().toString());
            preparedStatement.setString(2, inspector.getUsername());
            preparedStatement.setString(3, inspector.getPassword());
            preparedStatement.setString(4, inspector.getFirstName());
            preparedStatement.setString(5, inspector.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void update(Inspector inspector) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.UPDATE_INSPECTOR))) {
            preparedStatement.setString(1, inspector.getRole().toString());
            preparedStatement.setString(2, inspector.getUsername());
            preparedStatement.setString(3, inspector.getPassword());
            preparedStatement.setString(4, inspector.getFirstName());
            preparedStatement.setString(5, inspector.getLastName());
            preparedStatement.setLong(6, inspector.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.DELETE_INSPECTOR))) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public Inspector getByUserId(Long userId) {
        Inspector inspector = null;
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.GET_INSPECTOR_BY_USER))) {
            preparedStatement.setLong(1, userId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                inspector = InspectorExtractor.extractLazy(rs);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return inspector;
    }
}
