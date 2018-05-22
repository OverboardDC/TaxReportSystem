package com.training.reportsystem.model.dao.mapper;

import com.training.reportsystem.model.dao.extractor.TaxPayerExtractor;
import com.training.reportsystem.model.entity.TaxPayer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxPayerMapper extends Mapper<TaxPayer>{

    @Override
    protected void putValue(String key, ResultSet rs) throws SQLException {
        getResultMap().put(key, TaxPayerExtractor.extractExternally(rs));
    }
}
