package com.training.reportsystem.model.dao.mapper;

import java.util.HashMap;
import java.util.Map;

public class Mapper<T> {

    private Map<String, T> map = new HashMap<>();

    public Map<String, T> getMap(){
        return map;
    }

    public T get(String key) {
        return map.get(key);
    }
}
