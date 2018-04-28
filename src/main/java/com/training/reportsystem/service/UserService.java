package com.training.reportsystem.service;

import com.training.reportsystem.entity.user.User;

public interface UserService extends GenericService<User> {

    User login(String login, String password);

    boolean isUsernameUnique(String username);
}
