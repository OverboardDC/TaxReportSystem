package com.training.reportsystem.model.dao.impl.hibernate;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.util.SessionProvider;
import com.training.reportsystem.model.entity.Inspector;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/13/2018.
 */
@Repository
public class InspectorDaoHibernate implements InspectorDao {

    @Override
    public List<Inspector> findAll() {
        return SessionProvider.getSession().createQuery("from Inspector ", Inspector.class).list();
    }

    @Override
    public Inspector getByUserId(Long userId) {
        Inspector inspector;
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            inspector = session.createQuery("select t.inspector from TaxPayer t WHERE t.id = :userId", Inspector.class).
                    setParameter("userId", userId).uniqueResult();
        }
        return inspector;
    }
}
