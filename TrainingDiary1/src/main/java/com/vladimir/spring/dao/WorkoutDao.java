package com.vladimir.spring.dao;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface WorkoutDao {
    /**
     * Метод добавляет тренировку в список пользователя

     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     */
    public void addWorkoutToUser(Connection connection, int userId, String typeOfTraining, String date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException;


    /**
     * Получение id тренировки из таблицы тренировок
     * @param connection
     * @return
     */
    public Long getNextWorkoutId(Connection connection);


    public void printAllUserWorkout(Connection connection,String username) throws SQLException;

    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException;

    public void deleteWorkout(Connection connection, int workoutId) throws SQLException;


    /**
     * Метод получения списка всех тренировок пользователя
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Workout> getAllUserWorkout(Connection connection, int userId) throws SQLException;

    public void updateWorkout(Connection connection,int workoutId, String typeOfTraining, String dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException;
}
