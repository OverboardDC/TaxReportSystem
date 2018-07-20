package com.training.reportsystem.model.dao;

import com.training.reportsystem.model.entity.Inspector;

import java.util.List;

public interface InspectorDao{

    List<Inspector> findAll();

    Inspector getByUserId(Long userId);
}
