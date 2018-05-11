package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.User;

public interface UserService<T extends User> extends GenericService<T>{

    T login(String username, String password);

    boolean isUsernameUnique(String username);
}
