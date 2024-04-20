package com.vladimir.spring.Service;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.dao.WorkoutDao;
import com.vladimir.spring.dao.WorkoutDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Класс имплиментирующий интерфейс WorkoutService
 *
 */
public class WorkoutServiceImpl implements WorkoutService {
    WorkoutDao workoutDao = new WorkoutDaoImpl();

    /**
     * Добавление тренировки пользователю
     * @param connection
     * @param userId
     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     * @throws SQLException
     */
    @Override
    public void addWorkoutToUser(Connection connection, int userId, String typeOfTraining, String date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException {
        workoutDao.addWorkoutToUser(connection, userId, typeOfTraining, date, timeOfTraining, calories, countOfEx, countOfSteps);
    }

    /**
     * Получение id тренировки
     * @param connection
     * @return
     */
    @Override
    public Long getNextWorkoutId(Connection connection) {
        return workoutDao.getNextWorkoutId(connection);
    }

    /**
     * Выводит все тренировки конкретного пользователя
     * @param connection
     * @param username
     * @throws SQLException
     */
    @Override
    public void printAllUserWorkout(Connection connection, String username) throws SQLException {
        workoutDao.printAllUserWorkout(connection, username);
    }

    /**
     * Удаление тренировки по id
     * @param connection
     * @param workoutId
     * @throws SQLException
     */
    @Override
    public void deleteWorkout(Connection connection, int workoutId) throws SQLException{
        workoutDao.deleteWorkout(connection,workoutId);
    }

    /**
     * Редактирование тренировки
     * @param connection
     * @param workoutId
     * @param typeOfTraining
     * @param dateOfTraining
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     * @throws SQLException
     */
    @Override
    public void updateWorkout(Connection connection, int workoutId, String typeOfTraining, String dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException {
        workoutDao.updateWorkout(connection,workoutId,typeOfTraining,dateOfTraining,timeOfTraining,calories,countOfEx,countOfSteps);
    }




    /**
     * Выводит все тренировки всех пользователей
     * @param connection
     * @throws SQLException
     */
    @Override
    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException{
        workoutDao.ShowAllWorkoutsAllUsers(connection);
    }

}

