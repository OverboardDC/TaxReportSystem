package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.User;

public interface UserDao<T extends User> extends GenericDao<T>{

    T login(String username, String password);

    boolean isUsernameUnique(String username);
}
