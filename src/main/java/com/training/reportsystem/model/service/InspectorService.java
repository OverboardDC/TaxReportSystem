package com.training.reportsystem.model.service;

import com.training.reportsystem.model.entity.Inspector;

public interface InspectorService extends UserService<Inspector> {

    Inspector getByUserId(Long userId);
}
