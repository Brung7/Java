package com.vladimir.spring.Service;

import com.vladimir.spring.Models.Users;

public interface UsersService {
    /**
     * Метод добавляет пользователя в Map, содержащую всех пользователей
     * @param username
     * @param password
     * @param role
     */
    public void registerUser(String username, String password, String role);

    /**
     * Мето аутентификации пользователя
     * @param username
     * @param password
     * @return
     */
    public Users authentication(String username, String password );

    /**
     * Метод для получения роли пользователя
     * @param username
     * @return
     */
    public String getRole(String username);


}
