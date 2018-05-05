package com.training.reportsystem.model.service.impl;

import com.training.reportsystem.model.dao.UserDao;
import com.training.reportsystem.model.dao.impl.UserDaoImpl;
import com.training.reportsystem.model.entity.user.Inspector;
import com.training.reportsystem.model.entity.user.Role;
import com.training.reportsystem.model.entity.user.TaxPayer;
import com.training.reportsystem.model.entity.user.User;
import com.training.reportsystem.model.service.UserService;

import java.util.ArrayList;
import java.util.List;

//TODO This implementation is temporary
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    //  Temporary
    public User login(String username, String password) {
        List<User> list = new ArrayList<>();
        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().setId(2L).setUsername("client").setPassword("client").setRole(Role.CLIENT).build();
        Inspector inspector = new Inspector.InspectorBuilder().setId(3L).setUsername("inspector").setPassword("inspector").setRole(Role.INSPECTOR).build();
        Inspector admin = new Inspector.InspectorBuilder().setId(3L).setUsername("admin").setPassword("admin").setRole(Role.ADMIN).build();
        list.add(taxPayer);
        list.add(inspector);
        list.add(admin);

        // Db connection test
        userDao.login(username, password);

        for (User u : list) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("U: " + u);
                return u;
            }
        }
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
        System.out.println(user);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}
