package com.vladimir.spring.Controllers;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//Controller для работы с тренировками
public class WorkoutController extends AuthController{



    public List<Workout> workoutList = new ArrayList<>();

    //Метод добавления тренировки в список пользователя,
    //который создал эту тренировку
    public void addWorkoutToUser(Users user) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Добавить тренировку");
        System.out.println("Введите данные о тренировке");
        System.out.println("Тип тренировки");
        String typeOfTraining = scanner.nextLine();
        System.out.println("Введите дату тренировки (dd/MM/yyyy)");
        String date1 = scanner.nextLine();
        Date date = format.parse(date1);
        System.out.println("Время тренировки");
        int timeOfTraining = scanner.nextInt();
        System.out.println("Количество калорий");
        int calories = scanner.nextInt();
        System.out.println("Количество упражнений");
        int countOfEx = scanner.nextInt();
        System.out.println("Количество шагов");
        int countOfSteps = scanner.nextInt();
        Workout workout = new Workout(typeOfTraining, date,timeOfTraining,  calories,countOfEx, countOfSteps);
        user.getUserWorkoutList().add(workout);
        System.out.println("Тренировка была успешно добавлена");
    }

    //Метод вывода в консоль списка тренировок
    //и индекса каждой тренировки
    public List<Workout> getAllWorkouts(Users user){
        if(user.getUserWorkoutList().isEmpty()){
            System.out.println("Список тренировок пуст");
        }
        else {
            for (Workout w : user.getUserWorkoutList()) {
                int index = user.getUserWorkoutList().indexOf(w);
                System.out.println("Номер тренировки:" +index + " " + w.toString() + "\n");
            }

     }
        return workoutList ;
    }
    //Метод вывода в консоль отсортированного списка тренировок по дате
    public void getSortedListByDate(Users user){
        List<Workout> workoutList1 = new ArrayList<>(user.getUserWorkoutList());
        workoutList1.sort((w, w1) -> w.getDateOfTraining().compareTo(w1.getDateOfTraining()));
        List<Workout> sortedList = new ArrayList<>(workoutList1);
        for( Workout workout: sortedList){
            System.out.println(workout.toString());
        }

    }


    //Метод редактирования тренировки по индексу
    public void editWorkout(int index, Users user) throws ParseException {
        if(index >=0 && index<=user.getUserWorkoutList().size()){
            Scanner scanner = new Scanner(System.in);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Редактировать тренировку тренировку");
            System.out.println("Введите данные о тренировке");
            System.out.println("Тип тренировки");
            String typeOfTraining = scanner.nextLine();
            System.out.println("Введите дату тренировки (dd/MM/yyyy)");
            String date1 = scanner.nextLine();
            Date date = format.parse(date1);
            System.out.println("Время тренировки");
            int timeOfTraining = scanner.nextInt();
            System.out.println("Количество калорий");
            int calories = scanner.nextInt();
            System.out.println("Количество упражнений");
            int countOfEx = scanner.nextInt();
            System.out.println("Количество шагов");
            int countOfSteps = scanner.nextInt();
            Workout workout = new Workout(typeOfTraining, date,timeOfTraining,  calories,countOfEx, countOfSteps);
            user.getUserWorkoutList().set(index, workout);
            System.out.println("Тренировка была успешно изменена");
        }
        else{
            System.out.println("Тренировки с таким номером нет");
        }
    }
    //Метод удаления тренировки по индексу
    public void deleteWorkout(int index, Users user){
        user.getUserWorkoutList().remove(index);
        System.out.println("Тренировка была успешно удалена");
    }

    public List<Workout> getWorkoutList(){
        return workoutList;
    }

}
