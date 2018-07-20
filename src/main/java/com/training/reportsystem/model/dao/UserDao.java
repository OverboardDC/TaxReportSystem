package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.User;

public interface UserDao {

    User login(String username, String password);

    boolean isUsernameUnique(String username);
}
