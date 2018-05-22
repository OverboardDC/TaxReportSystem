package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.extractor.TaxPayerExtractor;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.PaginationDaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.TaxPayer;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.constants.LoggerMessages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaxPayerDaoImpl implements TaxPayerDao {

    @Override
    public TaxPayer login(String username, String password) {
        TaxPayer taxPayer = null;
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            PreparedStatement taxPayerStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.TAX_PAYER_LOGIN));
            taxPayerStatement.setString(1, username);
            taxPayerStatement.setString(2, password);
            ResultSet rs = taxPayerStatement.executeQuery();
            taxPayer = TaxPayerExtractor.extractFromRs(rs);
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return taxPayer;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.IS_TAX_PAYER_USERNAME_UNIQUE))) {
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
        List<TaxPayer> taxPayers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.FIND_ALL_TAX_PAYERS))) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taxPayers.add(TaxPayerExtractor.extractLazyFromRs(rs));
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return taxPayers;
    }

    @Override
    public TaxPayer getById(Long id) {
        TaxPayer taxPayer = null;
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.GET_TAX_PAYER_BY_ID))) {

            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taxPayer = TaxPayerExtractor.extractFromRs(rs);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return taxPayer;
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
    public void update(TaxPayer taxPayer) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.UPDATE_TAX_PAYER))) {
            preparedStatement.setLong(1, taxPayer.getInspector().getId());
            preparedStatement.setString(2, taxPayer.getUsername());
            preparedStatement.setString(3, taxPayer.getPassword());
            preparedStatement.setString(4, taxPayer.getFirstName());
            preparedStatement.setString(5, taxPayer.getLastName());
            preparedStatement.setString(6, taxPayer.getIdentificationCode());
            preparedStatement.setLong(7, taxPayer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.DELETE_TAX_PAYER))) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
    }

    @Override
    public List<TaxPayer> findAllWithoutInspector(Pagination pagination) {
        List<TaxPayer> taxPayers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getDataSource().getConnection()) {
            String query = DaoUtil.getQuery(Queries.FIND_ALL_TAX_PAYERS_WITHOUT_INSPECTOR);
            pagination.setTotalCount(PaginationDaoUtil.getTotalItemsCount(connection,
                    DaoUtil.getQuery(Queries.GET_COUNT_ALL_TAX_PAYERS_WITHOUT_INSPECTOR)));
            PreparedStatement preparedStatement = connection.prepareStatement(PaginationDaoUtil.formQueryWithPagination(query, pagination));

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                taxPayers.add(TaxPayerExtractor.extractLazyFromRs(rs));
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
}
