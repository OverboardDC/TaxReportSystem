package com.training.reportsystem.model.dao.impl.hibernate;

import com.training.reportsystem.model.dao.RequestDao;
import com.training.reportsystem.model.dao.util.SessionProvider;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Request;
import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.entity.TaxPayer;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/17/2018.
 */
@Repository
public class RequestDaoHibernate implements RequestDao {

    @Override
    public void create(Request request) {
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            session.save(request);
        }
    }

    @Override
    public List<Request> findByTaxPayerId(Long taxPayerId) {
        List<Request> requests;
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            requests = session.createQuery("from Request where taxPayer.id = ?1", Request.class).
                    setParameter(1, taxPayerId).list();
        }
        return requests;
    }

    @Override
    public List<Request> findByStatus(Status status) {
        List<Request> requests;
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            requests = session.createQuery("from Request where status = ?1", Request.class).
                    setParameter(1, status).list();
        }
        return requests;
    }

    @Override
    public void accept(Long requestId, Long taxPayerId, Long inspectorId) {
        try(Session session = SessionProvider.getSession()){
            session.beginTransaction();
            Request request = session.createQuery("from Request where id = ?1",
                    Request.class).setParameter(1, requestId).uniqueResult();
            TaxPayer taxPayer = session.createQuery("from TaxPayer where id = ?1",
                    TaxPayer.class).setParameter(1, taxPayerId).uniqueResult();
            taxPayer.setInspector(new Inspector.InspectorBuilder().setId(inspectorId).build());
            request.setStatus(Status.APPROVED);
            session.getTransaction().commit();
        }
    }

    @Override
    public void reject(Long requestId, String rejectReason) {
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            Request request = session.createQuery("from Request where id = ?1",
                    Request.class).setParameter(1, requestId).uniqueResult();
            request.setStatus(Status.REJECTED);
            request.setRejectReason(rejectReason);
            session.getTransaction().commit();
        }
    }

    @Override
    public boolean areThereRequestsWithStatus(Status status, Long taxPayerId) {
        boolean res;
        try (Session session = SessionProvider.getSession()){
            session.beginTransaction();
            res = !session.createQuery("from Request where status = ?1 and taxPayer.id = ?2",
                    Request.class).setParameter(1, status).
                    setParameter(2, taxPayerId).list().isEmpty();
        }
        return res;
    }
}
