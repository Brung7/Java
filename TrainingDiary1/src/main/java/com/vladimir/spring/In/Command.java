package com.vladimir.spring.In;
import com.vladimir.spring.Controllers.WorkoutController;
import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;

import java.text.ParseException;
import java.util.Scanner;

public class Command {
    WorkoutController workoutController = new WorkoutController();


    public void mainCommand(int command, Users user) throws ParseException {
        Scanner scanner = new Scanner(System.in);
      switch (command){
          case 0:
              System.out.println("Выход из приложения");
              break;
          case 1:
              workoutController.addWorkoutToUser(user);
              break;

          case 2:
              System.out.println("Введите номер тренировки, которую хотите изменить");
              workoutController.getAllWorkouts(user);
              int index = scanner.nextInt();
              workoutController.editWorkout(index, user);
              break;
          case 3:
              System.out.println("Удалить тренировку");
              workoutController.getAllWorkouts(user);
              System.out.println("Введите номер тренировки,которую хотите удалить");
              int indexToRemove = scanner.nextInt();
              workoutController.deleteWorkout(indexToRemove, user);
              break;
          case 4:
              System.out.println("Вывод всех тренировок");
              workoutController.getSortedListByDate(user);
              break;
          case 5:
              System.out.println("Это команда доступна только администратору");
              break;
          default:
              System.out.println("Nothing");
              break;

      }
      if("user".equals(user.getRole())) {
          System.out.println(
                  "Что делаем дальше?\n" +
                          "0 - Выйти из приложения\n" +
                          "1 - Добавить тренировку\n" +
                          "2 - Редактировать тренировку\n" +
                          "3 - Удалить тренировку\n" +
                          "4 - Вывести список тренировок\n"
          );
      }

    }

}
