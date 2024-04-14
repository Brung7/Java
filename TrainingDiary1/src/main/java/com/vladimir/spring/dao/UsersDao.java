package com.vladimir.spring.dao;

import com.vladimir.spring.Models.Users;

public interface UsersDao {
    /**
     * Метод регистрации пользователя
     * @param username
     * @param password
     * @param role
     */
    public void registerUser(String username, String password, String role);


    /**
     * Метод аутентификации пользователя
     * @param username
     * @param password
     * @return
     */
    public Users authentication(String username, String password );

    /**
     * Метод получения роли пользователя
     * @param username
     * @return
     */
    public String getRole(String username);
}
