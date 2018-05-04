package com.training.reportsystem.service.impl;

import com.training.reportsystem.entity.user.Inspector;
import com.training.reportsystem.entity.user.Role;
import com.training.reportsystem.entity.user.TaxPayer;
import com.training.reportsystem.entity.user.User;
import com.training.reportsystem.service.UserService;

import java.util.ArrayList;
import java.util.List;

//TODO This implementation is temporary
public class UserServiceImpl implements UserService {

    @Override
    //  Temporary
    public User login(String username, String password) {
        List<User> list = new ArrayList<>();
        User user = new User.UserBuilder().setId(1L).setUsername("user").setPassword("user").build();
        TaxPayer taxPayer = new TaxPayer.TaxPayerBuilder().setId(2L).setUsername("client").setPassword("client").build();
        Inspector inspector = new Inspector.InspectorBuilder().setId(3L).setUsername("inspector").setPassword("inspector").build();
        Inspector admin = new Inspector.InspectorBuilder().setId(3L).setUsername("admin").setPassword("admin").setRole(Role.ADMIN).build();
        list.add(user);
        list.add(taxPayer);
        list.add(inspector);
        list.add(admin);
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
