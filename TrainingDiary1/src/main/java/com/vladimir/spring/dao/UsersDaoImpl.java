package com.vladimir.spring.dao;

import com.vladimir.spring.Database.Db;
import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс имплементирующий интерфейс UsersDao
 */
public class UsersDaoImpl implements UsersDao {


    /**
     * Метод добавляет пользователя в Map users
     * @param username
     * @param password
     * @param role
     */
    @Override
    public void registerUser(Connection connection,String username, String password, String role) {
            try {
                insertToUsersTable(connection, username, password, role);
                System.out.println("Пользователь успешно зарегестрирован");
            }
            catch (SQLException e){
                System.out.println("Пользователь с таким именем уже существует");
            }

        }


    /**
     * Метод аутентификации пользователя, существует ли такой пользователь в Map
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean authentication(Connection connection, String username, String password) throws SQLException {

        Users user = getUserByUsername(connection, username);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("Авторизация успешна ");
                return true;
            } else {
                System.out.println("Неверный логин или пароль");
                return false;
            }
        }
        else {
            return false;
        }

    }

    /**
     * Метод проверяет обладание правами
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    @Override
    public boolean isAdmin(Connection connection, String username) throws SQLException {
        int userId = getUserIdByUsername(connection, username);
        String role = getUserRole(connection, userId);
        if("admin".equals(role)){
            return true;
        }
        else {
            return false;
        }
    }


    /**
     * Получение id пользователя
     * @param connection
     * @return
     */
    public Long getNextId(Connection connection){
        String sql = "SELECT nextval('trainingdiary.users_sequence')";
        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
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

    /**
     * Добавление пользователя в базу данных
     * @param connection
     * @param username
     * @param password
     * @param role
     * @throws SQLException
     */
    public void insertToUsersTable(Connection connection, String username, String password, String role) throws SQLException {
        Long id = getNextId(connection);
        String insertDataSql = "INSERT INTO TrainingDiary.users (id,username, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertDataSql);
        preparedStatement.setLong(1,id);
        preparedStatement.setString(2,username);
        preparedStatement.setString(3,password);
        preparedStatement.setString(4, role);
        preparedStatement.executeUpdate();
    }

    /**
     * Получение значений полей пользователя из БД
     * @param connection
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    public ResultSet selectUserFromTable(Connection connection, String username, String password) throws SQLException {
        String selectFromDb = "SELECT * FROM TrainingDiary.users WHERE username = username AND password = password";
        PreparedStatement preparedStatement = connection.prepareStatement(selectFromDb);
        return preparedStatement.executeQuery();

    }
    /**
     * Получение объекта пользователя по имени
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public Users getUserByUsername(Connection connection, String username) throws SQLException {
        String select = "SELECT * FROM TrainingDiary.users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);

        while (resultSet.next()){
            String name = resultSet.getString("username");
            String password1 = resultSet.getString("password");
            if(username.equals(name)) {
                return new Users(username, password1);
            }
        }

        return null;
    }

    /**
     * Получение id пользователя по имени
     * @param connection
     * @param username
     * @return
     * @throws SQLException
     */
    public int getUserIdByUsername(Connection connection, String username) throws SQLException {
        String query = "SELECT * FROM TrainingDiary.users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("username");
            int id = resultSet.getInt(1);
            if(username.equals(name)){
                return id;
            }
        }


        return -1;
    }

    /**
     * Получение имени пользователя по id
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public String getUserNameByUserId(Connection connection, int userId) throws SQLException {
        String query = "SELECT * FROM TrainingDiary.users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String name = resultSet.getString("username");
            int id = resultSet.getInt(1);
            if(id == userId){
                return name ;
            }
        }


        return "";
    }

    /**
     * Получение роли пользователя
     * @param connection
     * @param userId
     * @return
     * @throws SQLException
     */
    public String getUserRole(Connection connection, int userId) throws SQLException {
        String query = "SELECT * FROM trainingdiary.users WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,userId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            String role = resultSet.getString("role");
            return role;
        }
        return "";

    }

    /**
     * Вывод всех тренировок всех пользователей в консоль
     * @param connection
     * @return
     * @throws SQLException
     */

    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException {
        try{
            String sql = "SELECT trainingdiary.users.username, trainingdiary.workout.type_of_train, trainingdiary.workout.date_of_train, trainingdiary.workout.time_of_train, trainingdiary.workout.calories, trainingdiary.workout.count_of_ex, trainingdiary.workout.count_of_steps " +
                    "FROM trainingdiary.users JOIN trainingdiary.workout ON trainingdiary.users.id = trainingdiary.workout.user_id ORDER BY trainingdiary.users.id";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            String user = "";
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String typeOfTrain = resultSet.getString("type_of_train");
                String dateOfTrain = resultSet.getString("date_of_train");
                int timeOfTrain = resultSet.getInt("time_of_train");
                int calories = resultSet.getInt("calories");
                int countOfEx = resultSet.getInt("count_of_ex");
                int countOfSteps = resultSet.getInt("count_of_steps");
                if(!user.equals(username)){
                    System.out.println("Все тренировки пользователя: " + username);
                    user = username;
                }
                Workout workout = new Workout(typeOfTrain,dateOfTrain,timeOfTrain,calories,countOfEx,countOfSteps );
                System.out.println(workout);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
