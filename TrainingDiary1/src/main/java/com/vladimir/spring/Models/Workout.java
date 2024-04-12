package com.vladimir.spring.Models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class Workout {

    private String typeOfTraining;
    private Date dateOfTraining;
    private int timeOfTraining;
    private int calories;
    private int countOfEx;
    private int countOfSteps;

    public Workout(String typeOfTraining, Date dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        this.typeOfTraining = typeOfTraining;
        this.dateOfTraining = dateOfTraining;
        this.timeOfTraining = timeOfTraining;
        this.calories = calories;
        this.countOfEx = countOfEx;
        this.countOfSteps = countOfSteps;
    }
}
