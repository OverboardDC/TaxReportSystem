package com.training.reportsystem.model.dao.impl.hibernate;

import com.training.reportsystem.model.dao.ReportDao;
import com.training.reportsystem.model.dao.util.SessionProvider;
import com.training.reportsystem.model.entity.Report;
import com.training.reportsystem.model.entity.Status;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/12/2018.
 */
@Repository
public class ReportDaoHibernate implements ReportDao {


    @Override
    public Report getById(Long reportId) {
        Report report;
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            report = session.createQuery("from Report where id = ?1", Report.class)
                    .setParameter(1, reportId).uniqueResult();
        }
        return report;
    }

    @Override
    public void create(Report report) {
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            session.save(report);

        }
    }

    @Override
    public void edit(Report report) {
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            session.merge(report);
            session.getTransaction().commit();
        }
    }


    @Override
    public List<Report> findAllByUser(Long userId) {
        List<Report> reports;
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            reports = session.createQuery("FROM Report WHERE taxPayer.id = :userId", Report.class).
                    setParameter("userId", userId).list();
        }
        return reports;
    }

    @Override
    public List<Report> findAllByInspector(Long inspectorId) {
        List<Report> reports;
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            reports = session.createQuery("FROM Report WHERE inspector.id = :inspectorId", Report.class).
                    setParameter("inspectorId", inspectorId).list();
        }
        return reports;
    }

    @Override
    public void approveReport(Long reportId) {
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            session.createQuery("UPDATE Report SET status = ?1 WHERE id = ?2")
                    .setParameter(1, Status.APPROVED).setParameter(2, reportId).executeUpdate();
        }
    }

    @Override
    public void rejectReport(Long reportId, String rejectReason) {
        try (Session session = SessionProvider.getSession()) {
            session.beginTransaction();
            session.createQuery("UPDATE Report SET status = ?1," +
                    " rejectReason = ?2 WHERE id = ?3")
                    .setParameter(1, Status.REJECTED).setParameter(2, rejectReason).
                    setParameter(3, reportId).executeUpdate();
        }
    }
}
