package com.vladimir.spring.dao;

import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.vladimir.spring.dao.UsersDaoImpl.users;

/**
 * Класс имплементирующий интерфейс WorkoutDao
 */
public class WorkoutDaoImpl implements WorkoutDao{

    /**
     * Список тренировок пользователя
     */
    private List<Workout> workoutList = new ArrayList<>();

    /**
     * Реализация метода, для добавления тренировки пользователю
     * @param user
     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     */
    @Override
    public void addWorkoutToUser(Users user, String typeOfTraining, Date date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        Workout workout = new Workout(typeOfTraining, date,timeOfTraining,  calories,countOfEx, countOfSteps);
        user.getUserWorkoutList().add(workout);
    }

    /**
     * Реализация метода получения всех тренировок конкретного пользователя
     * @param user
     * @return
     */
    @Override
    public List<Workout> getAllWorkouts(Users user) {
        if(user.getUserWorkoutList().isEmpty()){
            System.out.println("Список тренировок пуст");
        }
        else {
            for (Workout w : user.getUserWorkoutList()) {
                int index = user.getUserWorkoutList().indexOf(w);
                System.out.println("Номер тренировки:" +index + " " + w.toString() + "\n");
            }

        }
        return workoutList;
    }

    /**
     * Реализация метода, который выводит отсортированный список тренировок пользователя по дате
     * @param user
     */
    @Override
    public void getSortedListByDate(Users user) {
        List<Workout> workoutList1 = new ArrayList<>(user.getUserWorkoutList());
        workoutList1.sort((w, w1) -> w.getDateOfTraining().compareTo(w1.getDateOfTraining()));
        List<Workout> sortedList = new ArrayList<>(workoutList1);
        for( Workout workout: sortedList){
            System.out.println(workout.toString());
        }

    }

    /**
     * Реализация метода, для редактирования тренировок
     * @param index
     * @param user
     * @param typeOfTraining
     * @param date
     * @param timeOfTraining
     * @param calories
     * @param countOfEx
     * @param countOfSteps
     */
    @Override
    public void editWorkout(int index, Users user, String typeOfTraining, Date date, int timeOfTraining, int calories, int countOfEx, int countOfSteps) {
        if(index >=0 && index<=user.getUserWorkoutList().size()){
            Workout workout = new Workout(typeOfTraining, date,timeOfTraining,  calories,countOfEx, countOfSteps);
            user.getUserWorkoutList().set(index, workout);
            System.out.println("Тренировка была успешно изменена");
        }
        else{
            System.out.println("Тренировки с таким номером нет");
        }

    }

    /**
     * Реализация метода удаления тренировки пользователя по индексу
     * @param index
     * @param user
     */
    @Override
    public void deleteWorkout(int index, Users user) {
        user.getUserWorkoutList().remove(index);
        System.out.println("Тренировка была успешно удалена");
    }

    /**
     * Реализация метода вывода всех тренировок всех пользователей
     */
    @Override
    public void showAllWorkouts() {
        for (Users user : users.values()) {
            for (Workout workout : user.getUserWorkoutList()) {
                System.out.println(user.getUsername() + " : " + workout);
            }
        }
    }


}
