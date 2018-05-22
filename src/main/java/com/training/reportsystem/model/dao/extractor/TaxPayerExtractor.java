package com.training.reportsystem.model.dao.extractor;

import com.training.reportsystem.model.dao.util.constant.Columns;
import com.training.reportsystem.model.entity.Role;
import com.training.reportsystem.model.entity.TaxPayer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxPayerExtractor {

    public static TaxPayer extractFromRs(ResultSet rs) throws SQLException {
        TaxPayer taxPayer = null;
        while (rs.next()) {
            Long id = rs.getLong(1);
            String username = rs.getString(3);
            String password = rs.getString(4);
            String firstName = rs.getString(5);
            String lastName = rs.getString(6);
            String identification_code = rs.getString(7);
            taxPayer = new TaxPayer.TaxPayerBuilder().setId(id).setUsername(username)
                    .setPassword(password).setFirstName(firstName).setLastName(lastName).
                            setIdentificationCode(identification_code).setRole(Role.CLIENT).build();
        }
        return taxPayer;
    }

    public static TaxPayer extractLazyFromRs(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String username = rs.getString(2);
        String firstName = rs.getString(3);
        String lastName = rs.getString(4);
        String identificationCode = rs.getString(5);
        return new TaxPayer.TaxPayerBuilder().setId(id).setUsername(username).setFirstName(firstName).setLastName(lastName)
                .setIdentificationCode(identificationCode).build();
    }

    public static TaxPayer extractExternally(ResultSet rs) throws SQLException {
        Long id = rs.getLong(Columns.TAX_PAYER_ID);
        String firstName = rs.getString(Columns.TAX_PAYER_FIRST_NAME);
        String lastName = rs.getString(Columns.TAX_PAYER_LAST_NAME);
        String username = rs.getString(Columns.TAX_PAYER_USERNAME);
        String identificationCode = rs.getString(Columns.TAX_PAYER_IDENTIFICATION_CODE);
        return new TaxPayer.TaxPayerBuilder().setId(id).setFirstName(firstName)
                .setLastName(lastName).setUsername(username)
                .setIdentificationCode(identificationCode).build();
    }
}
