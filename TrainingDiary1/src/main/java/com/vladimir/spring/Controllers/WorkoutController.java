package com.vladimir.spring.Controllers;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.Out.Out;
import com.vladimir.spring.Service.WorkoutService;
import com.vladimir.spring.Service.WorkoutServiceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 * Controller для работы с тренировками
 */
public class WorkoutController {
    WorkoutService workoutService = new WorkoutServiceImpl();
    Out out = new Out();

    /**
     * Метод добавления тренировки в список пользователя, который создал эту тренировку
     * @param user
     * @throws ParseException
     */
    public void addWorkoutToUser(Users user) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        out.enterTypeOfTraining();
        String typeOfTraining = scanner.nextLine();
        out.enterDateOfTraining();
        String date1 = scanner.nextLine();
        Date date = format.parse(date1);
        out.enterTimeOfTraining();
        int timeOfTraining = scanner.nextInt();
        out.enterCalories();
        int calories = scanner.nextInt();
        out.enterCountEx();
        int countOfEx = scanner.nextInt();
        out.enterCountOfSteps();
        int countOfSteps = scanner.nextInt();
        workoutService.addWorkoutToUser(user, typeOfTraining, date, timeOfTraining, calories, countOfEx, countOfSteps);
        System.out.println("Тренировка была успешно добавлена");
    }

    /**
     *  Метод вывода в консоль списка тренировок и индекса каждой тренировки
     */
    public List<Workout> getAllWorkouts(Users user) {
        return workoutService.getAllWorkouts(user);
    }

    /**
     * Метод вывода в консоль отсортированного списка тренировок по дате
     */

    public void getSortedListByDate(Users user) {
        workoutService.getSortedListByDate(user);
    }

    /**
     * Метод редактирования тренировки по индексу
     */
    public void editWorkout(int index, Users user) throws ParseException {
        if (index >= 0 && index <= user.getUserWorkoutList().size()) {
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Редактировать тренировку тренировку\n" +
                    "Введите данные о тренировке");
            out.enterTypeOfTraining();
            String typeOfTraining = scanner.nextLine();
            out.enterDateOfTraining();
            String date1 = scanner.nextLine();
            Date date = format.parse(date1);
            out.enterTimeOfTraining();
            int timeOfTraining = scanner.nextInt();
            out.enterCalories();
            int calories = scanner.nextInt();
            out.enterCountEx();
            int countOfEx = scanner.nextInt();
            out.enterCountOfSteps();
            int countOfSteps = scanner.nextInt();
            workoutService.editWorkout(index, user, typeOfTraining, date, timeOfTraining, calories, countOfEx, countOfSteps);
            System.out.println("Тренировка была успешно изменена");
        } else {
            System.out.println("Тренировки с таким номером нет");
        }
    }

    /**
     * Метод удаления тренировки по индексу
     */

    public void deleteWorkout(int index, Users user) {
        workoutService.deleteWorkout(index, user);
        System.out.println("Тренировка была успешно удалена");
    }

    /**
     * Метод выводит все тренировки всех пользователей
     */
    public void showAllWorkouts() {
        workoutService.showAllWorkouts();
    }
}
