package com.vladimir.spring.dao;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.util.Date;
import java.util.List;

public interface WorkoutDao {
    /**
     * Метод добавляет тренировку в список пользователя
     * @param user
     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     */
    public void addWorkoutToUser(Users user, String typeOfTraining, Date date, int timeOfTraining, int calories, int countOfEx, int countOfSteps);

    /**
     * Метод получения списка всех тренировок пользователя
     * @param user
     * @return
     */
    public List<Workout> getAllWorkouts(Users user);

    /**
     * Метод выводит отсортированный список тренировок пользователя по дате
     * @param user
     */
    public void getSortedListByDate(Users user);

    /**
     * Метод получает тренировку пользователя по индексу, а затем редактирует её
     * @param index
     * @param user
     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     */
    public void editWorkout(int index, Users user, String typeOfTraining, Date date, int timeOfTraining, int calories, int countOfEx, int countOfSteps);

    /**
     * Метод удаляет тренировку по индексу
     * @param index
     * @param user
     */
    public void deleteWorkout(int index, Users user);

    /**
     * Метод выводит все тренировки всех пользователей
     */
    public void showAllWorkouts();
}
