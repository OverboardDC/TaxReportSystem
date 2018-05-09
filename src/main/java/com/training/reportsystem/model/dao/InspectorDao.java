package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Inspector;

public interface InspectorDao extends UserDao<Inspector> {

    Inspector getByUserId(Long userId);
}
