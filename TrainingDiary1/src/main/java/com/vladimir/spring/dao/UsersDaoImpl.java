package com.vladimir.spring.dao;

import com.vladimir.spring.Models.Users;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс имплементирующий интерфейс UsersDao
 */
public class UsersDaoImpl implements UsersDao {
    /**
     * Map хранит в качестве ключа строку с username, а в качестве значения объект класса Users
     */
    static final Map<String, Users> users = new HashMap<>();

    /**
     * Метод добавляет пользователя в Map users
     * @param username
     * @param password
     * @param role
     */
    @Override
    public void registerUser(String username, String password, String role) {
        if(users.containsKey(username)){
            System.out.println("Пользователь с таким именем уже существует");
        }
        else{
            Users users1 = new Users(username, password, role);
            users.put(username, users1);

            System.out.println("Пользователь успешно зарегестрирован");
        }
    }

    /**
     * Метод аутентификации пользователя, существует ли такой пользователь в Map
     * @param username
     * @param password
     * @return
     */
    @Override
    public Users authentication(String username, String password) {
        Users user = users.get(username);
        if(users.containsKey(username)&&user.getPassword().equals(password)){
            System.out.println("Авторизация успешна ");
        }
        else{
            System.out.println("Неверный логин или пароль");

        }
        return user;
    }

    /**
     * Метод возвращает роль пользователя
     * @param username
     * @return
     */
    @Override
    public String getRole(String username) {
        Users user = users.get(username);
        return user!=null ? user.getRole(): null;
    }
}
