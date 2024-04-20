package com.vladimir.spring.Storage;

import com.vladimir.spring.Models.Audit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс аудита пользователя
 */
public class AuditStorage {


    /**
     * Метод добавления записи аудита в базу данных
     * @param connection
     * @param username
     * @param action
     * @throws SQLException
     */
    public void logAudit(Connection connection, String username, String action) throws SQLException {

        String sql = "INSERT INTO useraudit.audit (username, action, timestamp) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,action);
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        preparedStatement.executeUpdate();
    }


}



















