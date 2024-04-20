package com.vladimir.spring.Models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
/**
 * Модель тренировки
 */
public class Workout {
    private int id;
    private int userId;
    private String typeOfTraining;
    private String dateOfTraining;
    private int timeOfTraining;
    private int calories;
    private int countOfEx;
    private int countOfSteps;

    public Workout(String typeOfTraining, String dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        this.typeOfTraining = typeOfTraining;
        this.dateOfTraining = dateOfTraining;
        this.timeOfTraining = timeOfTraining;
        this.calories = calories;
        this.countOfEx = countOfEx;
        this.countOfSteps = countOfSteps;
    }

    public Workout(int id, int userId, String typeOfTraining, String dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        this.id = id;
        this.userId = userId;
        this.typeOfTraining = typeOfTraining;
        this.dateOfTraining = dateOfTraining;
        this.timeOfTraining = timeOfTraining;
        this.calories = calories;
        this.countOfEx = countOfEx;
        this.countOfSteps = countOfSteps;
    }

}
