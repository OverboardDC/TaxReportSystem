package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.dao.util.DaoUtil;
import com.training.reportsystem.model.dao.util.constant.Queries;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.Role;
import com.training.reportsystem.model.entity.user.TaxPayer;
import com.training.reportsystem.model.entity.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//TODO implement
public class TaxPayerDaoImpl implements TaxPayerDao {

    @Override
    public TaxPayer login(String username, String password) {
        try(Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DaoUtil.getQuery(Queries.TAX_PAYER_LOGIN))){
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            return extractFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TaxPayer extractFromResultSet(ResultSet rs) throws SQLException {
        TaxPayer taxPayer = null;
        while (rs.next()){
            Long id = rs.getLong(1);
            Inspector inspector = extractInspector(rs);
            String username = rs.getString(3);
            String password = rs.getString(4);
            String firstName = rs.getString(5);
            String lastName = rs.getString(6);
            String identification_code = rs.getString(7);
            taxPayer = new TaxPayer.TaxPayerBuilder().setId(id).setInspector(inspector).setUsername(username)
                    .setPassword(password).setFirstName(firstName).setLastName(lastName).
                    setIdentificationCode(identification_code).setRole(Role.CLIENT).build();
        }
        return taxPayer;
    }

    private Inspector extractInspector(ResultSet rs) throws SQLException {
        Long id = rs.getLong("i.id");
        if(!rs.wasNull()) {
            String firstName = rs.getString("i.firstname");
            String lastName = rs.getString("i.lastname");
            return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
        }
        return null;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return false;
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

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
