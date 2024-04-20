package com.vladimir.spring.Controllers;

import com.vladimir.spring.Out.Out;
import com.vladimir.spring.Service.UsersService;
import com.vladimir.spring.Service.UsersServiceImpl;
import com.vladimir.spring.Service.WorkoutService;
import com.vladimir.spring.Service.WorkoutServiceImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


/**
 * Controller для работы с тренировками
 */
public class WorkoutController {
    WorkoutService workoutService = new WorkoutServiceImpl();
    Out out = new Out();
    UsersService usersService = new UsersServiceImpl();

    /**
     * Метод добавления тренировки в список пользователя, который создал эту тренировку
     * @throws ParseException
     */
    public void addWorkoutToUser(String username,Connection connection) throws ParseException, SQLException {
        int id = usersService.getUserIdByUsername(connection,username);
        System.out.println(id);
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        out.enterTypeOfTraining();
        String typeOfTraining = scanner.nextLine();
        out.enterDateOfTraining();
        String date = scanner.nextLine();
        out.enterTimeOfTraining();
        int timeOfTraining = scanner.nextInt();
        out.enterCalories();
        int calories = scanner.nextInt();
        out.enterCountEx();
        int countOfEx = scanner.nextInt();
        out.enterCountOfSteps();
        int countOfSteps = scanner.nextInt();
        workoutService.addWorkoutToUser(connection, id, typeOfTraining, date, timeOfTraining, calories, countOfEx, countOfSteps);
        System.out.println("Тренировка была успешно добавлена");
    }


    /**
     * Метод редактирования тренировки по индексу
     */
    public void editUserWorkout(Connection connection, int workoutId) throws  SQLException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Редактировать тренировку тренировку\n" +
                    "Введите данные о тренировке");
            out.enterTypeOfTraining();
            String typeOfTraining = scanner.nextLine();
            out.enterDateOfTraining();
            String date = scanner.nextLine();
            out.enterTimeOfTraining();
            int timeOfTraining = scanner.nextInt();
            out.enterCalories();
            int calories = scanner.nextInt();
            out.enterCountEx();
            int countOfEx = scanner.nextInt();
            out.enterCountOfSteps();
            int countOfSteps = scanner.nextInt();
            workoutService.updateWorkout(connection, workoutId,typeOfTraining,date,timeOfTraining,calories,countOfEx,countOfSteps);
            System.out.println("Тренировка была успешно изменена");


    }


    public void printAllUserWorkout(Connection connection,String username) throws SQLException {
        workoutService.printAllUserWorkout(connection,username);
    }

    public void ShowAllWorkoutsAllUsers(Connection connection) throws SQLException{
        workoutService.ShowAllWorkoutsAllUsers(connection);
    }

    public void deleteWorkout(Connection connection, int workoutId) throws SQLException{
        workoutService.deleteWorkout(connection,workoutId);
        System.out.println("Тренировка была успешно удалена");
    }
}
