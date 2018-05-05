package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.user.User;

public interface UserService extends GenericService<User> {

    User login(String username, String password);

    boolean isUsernameUnique(String username);

}
