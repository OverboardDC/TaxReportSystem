package com.training.reportsystem.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class Mapper<T> {

    private Map<String, T> resultMap = new HashMap<>();

    protected Map<String, T> getResultMap() {
        return resultMap;
    }

    protected abstract void putValue(String key, ResultSet rs) throws SQLException;

    public T map(String key, ResultSet rs) throws SQLException {
        if (!getResultMap().containsKey(key)) {
            putValue(key, rs);
        }
        return getResultMap().get(key);
    }
}
