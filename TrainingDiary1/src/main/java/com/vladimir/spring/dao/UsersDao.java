package com.vladimir.spring.dao;

import com.vladimir.spring.Models.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UsersDao {
    /**
     * Метод регистрации пользователя
     * @param username
     * @param password
     * @param role
     */
    public void registerUser(Connection connection, String username, String password, String role);


    /**
     * Метод аутентификации пользователя
     * @param username
     * @param password
     * @return
     */
    public boolean authentication(Connection connection,String username, String password ) throws SQLException;

    /**
     * Метод проверки пользователя на обладание правами администратора
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public boolean isAdmin(Connection connection, String username) throws SQLException;

    /**
     * Метод получения id пользователя
     * @param connection
     * @return
     */
    public Long getNextId(Connection connection);

    /**
     * Метод добавление значений в базу данных
     * @param connection
     * @param username
     * @param password
     * @param role
     * @throws SQLException
     */
    public void insertToUsersTable(Connection connection, String username, String password, String role) throws SQLException;

    /**
     * Метод получение значений из базы данных
     * @param connection
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public ResultSet selectUserFromTable(Connection connection, String username, String password) throws SQLException;

    /**
     * Метод получения объекта user по его имени
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public Users getUserByUsername(Connection connection, String username) throws SQLException;

    /**
     * Метод получения id пользователя по его имени
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public int getUserIdByUsername(Connection connection, String username) throws SQLException;

    /**
     * Метод получения имени пользователя по его id
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public String getUserNameByUserId(Connection connection, int userId) throws SQLException;

    /**
     * Метод получения роли пользователя
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public String getUserRole(Connection connection, int userId) throws SQLException;

    /**
     * Метод вывода всех тренировок всех пользователей
     * @param connection
     * @throws SQLException
     */
    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException;

}
