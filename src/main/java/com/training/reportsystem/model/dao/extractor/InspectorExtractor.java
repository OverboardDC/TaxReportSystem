package com.training.reportsystem.model.dao.extractor;

import com.training.reportsystem.model.dao.util.constant.Columns;
import com.training.reportsystem.model.entity.Inspector;
import com.training.reportsystem.model.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InspectorExtractor{

    public static Inspector extract(ResultSet rs) throws SQLException {
        Inspector inspector = null;
        while (rs.next()){
            Long id = rs.getLong(1);
            Role role =  Role.valueOf(rs.getString(2).toUpperCase());
            String username = rs.getString(3);
            String password = rs.getString(4);
            String firstName = rs.getString(5);
            String lastName = rs.getString(6);
            inspector = new Inspector.InspectorBuilder().setId(id).setRole(role).setUsername(username).setPassword(password)
                    .setFirstName(firstName).setLastName(lastName).build();
        }
        return inspector;
    }

    public static Inspector extractLazy(ResultSet rs) throws SQLException {
        Long id = rs.getLong(1);
        String firstName = rs.getString(2);
        String lastName = rs.getString(3);
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }

    public static Inspector extractExternally(ResultSet rs) throws SQLException {
        Long id = rs.getLong(Columns.INSPECTOR_ID);
        String firstName = rs.getString(Columns.INSPECTOR_FIRST_NAME);
        String lastName = rs.getString(Columns.INSPECTOR_LAST_NAME);
        return new Inspector.InspectorBuilder().setId(id).setFirstName(firstName).setLastName(lastName).build();
    }
}
