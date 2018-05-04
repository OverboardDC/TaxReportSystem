package com.training.reportsystem.dao.impl;

import com.training.reportsystem.dao.UserDao;
import com.training.reportsystem.entity.user.User;

import java.util.List;

//TODO implement
public class UserDaoImpl implements UserDao {

    @Override
    public User login(String username, String password) {
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
