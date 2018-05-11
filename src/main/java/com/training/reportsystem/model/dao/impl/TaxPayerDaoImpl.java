package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.Role;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//TODO implement
//TODO create mappers!
public class TaxPayerDaoImpl implements TaxPayerDao {

    @Override
    //TODO refactor
    public TaxPayer login(String username, String password) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            PreparedStatement taxPayerStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.TAX_PAYER_LOGIN));
            taxPayerStatement.setString(1, username);
            taxPayerStatement.setString(2, password);
            ResultSet rs = taxPayerStatement.executeQuery();
            return extractFromResultSet(rs);
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.IS_USERNAME_UNIQUE))) {
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
    public List<TaxPayer> findAll() {
        return null;
    }

    @Override
    public TaxPayer getById(Long id) {
        return null;
    }

    @Override
    public void create(TaxPayer taxPayer) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.CREATE_TAX_PAYER))) {
            preparedStatement.setString(1, taxPayer.getUsername());
            preparedStatement.setString(2, taxPayer.getPassword());
            preparedStatement.setString(3, taxPayer.getFirstName());
            preparedStatement.setString(4, taxPayer.getLastName());
            preparedStatement.setString(5, taxPayer.getIdentificationCode());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void update(TaxPayer t) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<TaxPayer> findAllWithoutInspector() {
        List<TaxPayer> taxPayers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_TAX_PAYERS_WITHOUT_INSPECTOR))) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taxPayers.add(extractLazyFromResultSet(rs));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return taxPayers;
    }

    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.ASSIGN_INSPECTOR))) {

            preparedStatement.setLong(1, inspectorId);
            preparedStatement.setLong(2, taxPayer_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    private TaxPayer extractFromResultSet(ResultSet rs) throws SQLException {
        TaxPayer taxPayer = null;
        while (rs.next()) {
            Long id = rs.getLong(1);
            String username = rs.getString(3);
            String password = rs.getString(4);
            String firstName = rs.getString(5);
            String lastName = rs.getString(6);
            String identification_code = rs.getString(7);
            taxPayer = new TaxPayer.TaxPayerBuilder().setId(id).setUsername(username)
                    .setPassword(password).setFirstName(firstName).setLastName(lastName).
                            setIdentificationCode(identification_code).setRole(Role.CLIENT).build();
        }
        return taxPayer;
    }

    private TaxPayer extractLazyFromResultSet(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String username = rs.getString(2);
        String firstName = rs.getString(3);
        String lastName = rs.getString(4);
        String identificationCode = rs.getString(5);
        return new TaxPayer.TaxPayerBuilder().setId(id).setUsername(username).setFirstName(firstName).setLastName(lastName)
                .setIdentificationCode(identificationCode).build();
    }
}