package com.vladimir.spring.Service;

import com.vladimir.spring.Models.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UsersService {
    /**
     * Метод добавляет пользователя в Map, содержащую всех пользователей
     * @param username
     * @param password
     * @param role
     */
    public void registerUser(Connection connection, String username, String password, String role);

    /**
     * Мето аутентификации пользователя
     * @param username
     * @param password
     * @return
     */
    public boolean authentication(Connection connection,String username, String password ) throws SQLException;



    public boolean isAdmin(Connection connection, String username) throws SQLException;

    public Long getNextId(Connection connection);

    public void insertToUsersTable(Connection connection, String username, String password, String role) throws SQLException;

    public ResultSet selectUserFromTable(Connection connection, String username, String password) throws SQLException;

    public Users getUserByUsername(Connection connection, String username) throws SQLException;

    public int getUserIdByUsername(Connection connection, String username) throws SQLException;

    public String getUserNameByUserId(Connection connection, int userId) throws SQLException;

    public String getUserRole(Connection connection, int userId) throws SQLException;
    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException;

}
