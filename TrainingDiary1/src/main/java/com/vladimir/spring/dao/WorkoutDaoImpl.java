package com.vladimir.spring.dao;

import com.vladimir.spring.Database.Db;
import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Класс имплементирующий интерфейс WorkoutDao
 */
public class WorkoutDaoImpl implements WorkoutDao{

    Db db = new Db();

    UsersDao usersDao = new UsersDaoImpl();


    /**
     * Реализация метода, для добавления тренировки пользователю
     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     */
    @Override
    public void addWorkoutToUser(Connection connection, int userId, String typeOfTraining, String date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException {
        insertToWorkoutTable(connection,userId, typeOfTraining, date, timeOfTraining,  calories, countOfEx, countOfSteps);

    }


    /**
     * Получение id тренировки из таблицы тренировок
     * @param connection
     * @return
     */
    @Override
    public Long getNextWorkoutId(Connection connection){
        String sql = "SELECT nextval('trainingdiary.workout_sequence')";
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                return resultSet.getLong(1);
            }
            else {
                System.out.println("No next value of sequence");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }





    @Override
    public void printAllUserWorkout(Connection connection,String username) throws SQLException {
        int userId = usersDao.getUserIdByUsername(connection,username);
        List<Workout> workoutList1 = getAllUserWorkout(connection,userId);
        if(workoutList1.isEmpty()){
            System.out.println("Cписок тренировок пуст");
        }
        else {
            System.out.println("Тренировки пользователя с id: " + username);
            for(Workout workout: workoutList1){
                System.out.println(workout);
            }
        }
    }
    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException{
        usersDao.ShowAllWorkoutsAllUsers(connection);
    }



    /**
     * Добавление тренировки в базу данных
     * @param connection
     * @param userId
     * @param typeOfTraining
     * @param dateOfTraining
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     * @throws SQLException
     */
    public void insertToWorkoutTable(Connection connection, int userId, String typeOfTraining, String dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException {
        Long id = getNextWorkoutId(connection);
        String query = "INSERT INTO TrainingDiary.workout (id,user_id,type_of_train,date_of_train,time_of_train, calories,count_of_ex,count_of_steps) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1,id);
        preparedStatement.setInt(2, userId);
        preparedStatement.setString(3,typeOfTraining);
        preparedStatement.setString(4, dateOfTraining);
        preparedStatement.setInt(5,timeOfTraining);
        preparedStatement.setInt(6,calories);
        preparedStatement.setInt(7,countOfEx);
        preparedStatement.setInt(8,countOfSteps);
        preparedStatement.executeUpdate();
    }

    /**
     * Вывод в консоль всех тренировок конкретного пользователя
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Workout> getAllUserWorkout(Connection connection, int userId) throws SQLException {
        List<Workout> workoutList = new ArrayList<>();
        String query = "SELECT * FROM trainingdiary.workout WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,userId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int traningId = resultSet.getInt("id");
            int userID = resultSet.getInt("user_id");
            String typeOfTrain = resultSet.getString("type_of_train");
            String dateOfTrain = resultSet.getString("date_of_train");
            int timeOfTrain = resultSet.getInt("time_of_train");
            int calories = resultSet.getInt("calories");
            int countOfEx = resultSet.getInt("count_of_ex");
            int countOfSteps = resultSet.getInt("count_of_steps");

            Workout workout = new Workout(traningId,userID,typeOfTrain,dateOfTrain,timeOfTrain,calories,countOfEx,countOfSteps);

            workoutList.add(workout);

        }
        return workoutList;
    }


    /**
     * Метод редактирования тренировки
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
    public void updateWorkout(Connection connection,int workoutId, String typeOfTraining, String dateOfTraining, int timeOfTraining, int calories, int countOfEx, int countOfSteps) throws SQLException {
        String query = "UPDATE trainingdiary.workout SET type_of_train = ?, date_of_train = ?, time_of_train =?, calories = ?, count_of_ex =?, count_of_steps =? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,typeOfTraining);
        statement.setString(2,dateOfTraining);
        statement.setInt(3,timeOfTraining);
        statement.setInt(4,calories);
        statement.setInt(5,countOfEx);
        statement.setInt(6,countOfSteps);
        statement.setInt(7,workoutId);
        int resultSet = statement.executeUpdate();
        if (resultSet > 0) {
            System.out.println("Тренировка успешно обновлена.");
        } else {
            System.out.println("Не удалось обновить тренировку.");
        }
    }

    /**
     * Удаление тренировки
     * @param connection
     * @param workoutId
     * @throws SQLException
     */
    @Override
    public void deleteWorkout(Connection connection, int workoutId) throws SQLException {
        String query = "DELETE FROM trainingdiary.workout WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,workoutId);
        preparedStatement.executeUpdate();

    }

}
