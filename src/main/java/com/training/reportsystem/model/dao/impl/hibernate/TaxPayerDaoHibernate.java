package com.training.reportsystem.model.dao.impl.hibernate;

import com.training.reportsystem.model.dao.TaxPayerDao;
import com.training.reportsystem.model.dao.util.SessionProvider;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.TaxPayer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/17/2018.
 */
@Repository
public class TaxPayerDaoHibernate implements TaxPayerDao {

    @Override
    public void create(TaxPayer taxPayer) {
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            session.save(taxPayer);
            session.getTransaction().commit();
        }
    }

    @Override
    public List<TaxPayer> findAllWithoutInspector() {
        List<TaxPayer> taxPayers;
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            taxPayers = session.createQuery("from TaxPayer where inspector is null",
                    TaxPayer.class).list();
        }
        return taxPayers;
    }

    @Override
    public void assignInspector(Long taxPayer_id, Long inspectorId) {
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            TaxPayer taxPayer = session.createQuery("from TaxPayer where id = ?1",
                    TaxPayer.class).setParameter(1, taxPayer_id).uniqueResult();
            taxPayer.setInspector(new Inspector.InspectorBuilder().setId(inspectorId).build());
            session.getTransaction().commit();
        }
    }
}
