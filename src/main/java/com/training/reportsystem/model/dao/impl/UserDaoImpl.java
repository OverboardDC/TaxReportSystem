package com.training.reportsystem.model.dao.impl;

import com.training.reportsystem.model.dao.UserDao;
import com.training.reportsystem.model.dao.util.ConnectionPool;
import com.training.reportsystem.model.entity.user.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//TODO implement
public class UserDaoImpl implements UserDao {

    @Override
    //Test
    public User login(String username, String password) {
        try {
            Connection connection = ConnectionPool.getInstance().getDataSource().getConnection();
            System.out.println("Connection: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
