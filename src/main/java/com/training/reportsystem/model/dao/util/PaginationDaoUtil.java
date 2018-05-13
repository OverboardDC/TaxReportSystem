package com.training.reportsystem.model.dao.util;

import com.training.reportsystem.model.service.util.Pagination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaginationDaoUtil {

    public static String formQueryWithPagination(String query, Pagination pagination) {
        StringBuilder stringBuilder = new StringBuilder(query);
        stringBuilder.append(" ");
        stringBuilder.append("LIMIT");
        stringBuilder.append(" ");
        stringBuilder.append((pagination.getPage() * pagination.getItemsOnPage()) - pagination.getItemsOnPage());
        stringBuilder.append(",");
        stringBuilder.append(pagination.getItemsOnPage());
        return new String(stringBuilder);
    }

    public static int getTotalItemsCount(Connection connection, String query, Long id) throws SQLException {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
             preparedStatement.setLong(1, id);
             ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        }
        return count;
    }
}
