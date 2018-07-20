package com.training.reportsystem.model.service.impl.hibernate;

import com.training.reportsystem.model.dao.InspectorDao;
import com.training.reportsystem.model.dao.impl.hibernate.InspectorDaoHibernate;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.service.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Yevhen_Kushpii on 7/13/2018.
 */
@Service
public class InspectorServiceHibernate implements InspectorService {

    private InspectorDao inspectorDao;

    @Override
    public List<Inspector> findAll() {
        return inspectorDao.findAll();
    }

    @Override
    public Inspector getByUserId(Long userId) {
        return inspectorDao.getByUserId(userId);
    }

    @Autowired
    public void setInspectorDao(InspectorDao inspectorDao) {
        this.inspectorDao = inspectorDao;
    }
}
