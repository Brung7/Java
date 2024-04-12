package com.vladimir.spring.Controllers;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.util.*;

//Controller для работы с пользователем
public class AuthController {

    private static final Map<String, Users> users = new HashMap<>();

    //Метод регистрации пользователя
    public void registerUser(String username, String password, String role){
        if(users.containsKey(username)){
            System.out.println("Пользователь с таким именем уже существует");
        }
        else{
            Users users1 = new Users(username, password, role);
            users.put(username, users1);

            System.out.println("Пользователь успешно зарегестрирован");
        }

    }

    //Метод аутентификации пользователя
    public Users authentication(String username, String password ){
        Users user = users.get(username);
        if(users.containsKey(username)&&user.getPassword().equals(password)){
            System.out.println("Авторизация успешна ");
        }
        else{
            System.out.println("Неверный логин или пароль");

        }
        return user;
    }


    //Метод позволяющий вывести все тренировки всех пользователей
    public void viewAllWorkouts() {
        if (users.isEmpty()) {
            System.out.println("В Map нет пользователей");
            return;
        }

        Set<Map.Entry<String, Users>> entrySet = users.entrySet();
        if (entrySet.isEmpty()) {
            System.out.println("Map пустая");
            return;
        }


            for(Users user : users.values()) {
                for (Workout workout : user.getUserWorkoutList()) {
                    System.out.println(user.getUsername()+ " : " + workout);
                }

        }
    }

    //Метод получение роли пользователя
    public String getRole(String username){

        Users user = users.get(username);
        return user!=null ? user.getRole(): null;
    }



}
