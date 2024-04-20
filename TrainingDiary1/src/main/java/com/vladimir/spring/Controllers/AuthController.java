package com.vladimir.spring.Controllers;

import com.vladimir.spring.Database.Db;
import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.Service.UsersServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Controller для работы с пользователем
 */
public class AuthController {

    Db db = new Db();
    UsersServiceImpl usersService = new UsersServiceImpl();

    /**
     * Метод регистрации пользователя
     * @param username
     * @param password
     * @param role
     */
    public void registerUser(Connection connection, String username, String password, String role){
        usersService.registerUser(connection,username,password,role);

    }

    /**
     * Метод аутентификации пользователя
     */

    public boolean authentication(Connection connection,String username, String password ) throws SQLException {
        return usersService.authentication(connection,username,password);
    }




    /**
     * Метод проверяет, является ли пользователь администраторам, возвращает true если является, false если нет
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public boolean isAdmin(Connection connection, String username) throws SQLException{
        return usersService.isAdmin(connection, username);
    }

}
