package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.user.User;

public interface UserDao extends GenericDao<User> {

    User login(String username, String password);

    boolean isUsernameUnique(String username);
}
