package com.vladimir.spring.Service;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.dao.UsersDao;
import com.vladimir.spring.dao.UsersDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс имплементирующий интерфейс UsersService
 */
public class UsersServiceImpl implements UsersService{

    UsersDao usersDao = new UsersDaoImpl();
    @Override
    public void registerUser(Connection connection, String username, String password, String role) {
        usersDao.registerUser(connection,username,password,role);
    }

    @Override
    public boolean authentication(Connection connection,String username, String password) throws SQLException {
        return usersDao.authentication(connection,username,password);
    }


    @Override
    public boolean isAdmin(Connection connection, String username) throws SQLException{
        return usersDao.isAdmin(connection,username);
    }

    @Override
    public Long getNextId(Connection connection) {
        return usersDao.getNextId(connection);
    }

    @Override
    public void insertToUsersTable(Connection connection, String username, String password, String role) throws SQLException {
        usersDao.insertToUsersTable(connection,username,password,role);
    }

    @Override
    public ResultSet selectUserFromTable(Connection connection, String username, String password) throws SQLException {
        return usersDao.selectUserFromTable(connection,username,password);
    }

    @Override
    public Users getUserByUsername(Connection connection, String username) throws SQLException {
        return usersDao.getUserByUsername(connection,username);
    }

    @Override
    public int getUserIdByUsername(Connection connection, String username) throws SQLException {
        return usersDao.getUserIdByUsername(connection,username);
    }

    @Override
    public String getUserNameByUserId(Connection connection, int userId) throws SQLException {
        return usersDao.getUserNameByUserId(connection,userId);
    }

    @Override
    public String getUserRole(Connection connection, int userId) throws SQLException {
        return usersDao.getUserRole(connection,userId);
    }

    @Override
    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException {
        usersDao.ShowAllWorkoutsAllUsers(connection);
    }
}
