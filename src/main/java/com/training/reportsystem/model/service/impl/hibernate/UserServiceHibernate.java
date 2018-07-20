package com.training.reportsystem.model.service.impl.hibernate;

import com.training.reportsystem.model.dao.UserDao;
import com.training.reportsystem.model.dao.impl.hibernate.UserDaoHibernate;
import com.training.reportsystem.model.entity.User;
import com.training.reportsystem.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/13/2018.
 */
@Service
public class UserServiceHibernate implements UserService {

    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public boolean isUsernameUnique(String username) {
        return userDao.isUsernameUnique(username);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
