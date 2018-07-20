package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.User;

public interface UserService {

    User login(String username, String password);

    boolean isUsernameUnique(String username);
}
