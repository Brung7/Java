package com.vladimir.spring.Service;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.dao.WorkoutDao;
import com.vladimir.spring.dao.WorkoutDaoImpl;

import java.util.Date;
import java.util.List;

/**
 * Класс имплиментирующий интерфейс WorkoutService
 *
 */
public class WorkoutServiceImpl implements WorkoutService {
    WorkoutDao workoutDao = new WorkoutDaoImpl();

    @Override
    public void addWorkoutToUser(Users user, String typeOfTraining, Date date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        workoutDao.addWorkoutToUser(user,typeOfTraining,date,timeOfTraining,calories,countOfEx,countOfSteps);
    }
    @Override
    public List<Workout> getAllWorkouts(Users user) {
        return workoutDao.getAllWorkouts(user);
    }
    @Override
    public void getSortedListByDate(Users user) {
        workoutDao.getSortedListByDate(user);

    }
    @Override
    public void editWorkout(int index, Users user, String typeOfTraining, Date date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        workoutDao.editWorkout(index,user,typeOfTraining,date,timeOfTraining,calories,countOfEx,countOfSteps);
    }
    @Override
    public void deleteWorkout(int index, Users user) {
        workoutDao.deleteWorkout(index,user);

    }
    @Override
    public void showAllWorkouts() {
        workoutDao.showAllWorkouts();
    }
}
