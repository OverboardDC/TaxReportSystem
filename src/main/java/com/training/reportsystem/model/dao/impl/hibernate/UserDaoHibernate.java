package com.training.reportsystem.model.dao.impl.hibernate;

import com.training.reportsystem.model.dao.UserDao;
import com.training.reportsystem.model.dao.util.SessionProvider;
import com.training.reportsystem.model.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Yevhen_Kushpii on 7/13/2018.
 */
@Repository
public class UserDaoHibernate implements UserDao {


    @Override
    public User login(String username, String password) {
        User user;
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            user = session.createQuery("from User WHERE username = :username  and password = :password", User.class).
                    setParameter("username", username).setParameter("password", password).
                    uniqueResult();
        }
        return user;
    }

    @Override
    public boolean isUsernameUnique(String username) {
        Optional<User> user;
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            user = Optional.ofNullable(SessionProvider.getSession().createQuery("from User WHERE username = ?1", User.class)
                    .setParameter(1, username).uniqueResult());
        }
        return !user.isPresent();
    }
}
