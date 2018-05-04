package com.training.reportsystem.dao;

import com.training.reportsystem.entity.user.User;

public interface UserDao extends GenericDao<User> {

    User login(String username, String password);

    boolean isUsernameUnique(String username);
}
