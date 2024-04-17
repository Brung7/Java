package com.vladimir.spring.Models;

import com.vladimir.spring.Controllers.WorkoutController;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
/**
 * Модель пользователя
 */
public class Users {

    private String username;
    private String password;
    private String role;
    private List<Workout> userWorkoutList = new ArrayList<>();

    public Users(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
