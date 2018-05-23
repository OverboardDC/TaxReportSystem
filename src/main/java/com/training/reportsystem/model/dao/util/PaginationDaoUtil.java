package com.training.reportsystem.model.dao.util;

import com.training.reportsystem.model.entity.Status;
import com.training.reportsystem.model.service.util.Pagination;
import com.training.reportsystem.util.constants.LoggerMessages;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaginationDaoUtil {

    private static Logger logger = Logger.getRootLogger();

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

    public static int getTotalItemsCount(Connection connection, String query, Long id) {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
             preparedStatement.setLong(1, id);
             ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return count;
    }

    public static int getTotalItemsCount(Connection connection, String query){
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return count;
    }

    public static int getTotalItemsCount(Connection connection, String query, Status status) {
        int count = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1, status.toString());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error(LoggerMessages.SQL_EXCEPTION);
            e.printStackTrace();
        }
        return count;
    }
}
