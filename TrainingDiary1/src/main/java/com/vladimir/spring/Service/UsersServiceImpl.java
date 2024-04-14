package com.vladimir.spring.Service;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.dao.UsersDao;
import com.vladimir.spring.dao.UsersDaoImpl;

/**
 * Класс имплементирующий интерфейс UsersService
 */
public class UsersServiceImpl implements UsersService{

    UsersDao usersDao = new UsersDaoImpl();
    @Override
    public void registerUser(String username, String password, String role) {
        usersDao.registerUser(username,password,role);
    }

    @Override
    public Users authentication(String username, String password) {
        return usersDao.authentication(username,password);
    }

    @Override
    public String getRole(String username) {
        return usersDao.getRole(username);
    }
}
