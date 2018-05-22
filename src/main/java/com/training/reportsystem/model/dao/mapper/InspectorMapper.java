package com.training.reportsystem.model.dao.mapper;

import com.training.reportsystem.model.dao.extractor.InspectorExtractor;
import com.training.reportsystem.model.entity.Inspector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InspectorMapper extends Mapper<Inspector> {

    @Override
    protected void putValue(String key, ResultSet rs) throws SQLException {
        getResultMap().put(key, InspectorExtractor.extractExternally(rs));
    }
}
