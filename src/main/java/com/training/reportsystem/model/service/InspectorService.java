package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Inspector;

import java.util.List;

public interface InspectorService {

    List<Inspector> findAll();

    Inspector getByUserId(Long userId);
}
