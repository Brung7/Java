package com.vladimir.spring.Controllers;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.Service.UsersServiceImpl;

import java.util.*;

/**
 * Controller для работы с пользователем
 */
public class AuthController {

    UsersServiceImpl usersService = new UsersServiceImpl();

    /**
     * Метод регистрации пользователя
     * @param username
     * @param password
     * @param role
     */
    public void registerUser(String username, String password, String role){
        usersService.registerUser(username,password,role);

    }

    /**
     * Метод аутентификации пользователя
     */

    public Users authentication(String username, String password ){
        return usersService.authentication(username,password);
    }

    /**
     * Метод получение роли пользователя
     * @param username
     * @return
     */
    public String getRole(String username){
        return usersService.getRole(username);

    }

}
