package com.vladimir.spring.In;
import com.vladimir.spring.Controllers.WorkoutController;
import com.vladimir.spring.Models.Audit;
import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.Storage.AuditStorage;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Класс с основными командами для взаимодействия пользователя с приложением
 */
public class Command {
    WorkoutController workoutController = new WorkoutController();
    AuditStorage auditStorage = new AuditStorage();

    /**
     * Метод, который Создает аудит пользователя
     * @param user
     * @param action
     */
    public void createAudit(Users user, String action){
        auditStorage.addToAudit(user.getUsername(), new Audit(user.getUsername(), LocalDateTime.now(), action));

    }


    public void mainCommand(int command, Users user) throws ParseException {
        Scanner scanner = new Scanner(System.in);
      switch (command){
          case 0:
              createAudit(user, "Выходи их приложения");
              break;
          case 1:
              workoutController.addWorkoutToUser(user);
              createAudit(user, "Добавил тренировку");
              break;
          case 2:
              System.out.println("Введите номер тренировки, которую хотите изменить");
              workoutController.getAllWorkouts(user);
              int index = scanner.nextInt();
              workoutController.editWorkout(index, user);
              createAudit(user, "Изменил тренировку");

              break;
          case 3:
              workoutController.getAllWorkouts(user);
              System.out.println("Введите номер тренировки,которую хотите удалить");
              int indexToRemove = scanner.nextInt();
              workoutController.deleteWorkout(indexToRemove, user);
              createAudit(user, "Удалил тренировку");
              break;
          case 4:
              workoutController.getSortedListByDate(user);
              createAudit(user, "Вывел все тренировки");
              break;
          case 5:
              if("user".equals(user.getRole())) {
                  System.out.println("Это команда доступна только администратору");
              }
              else {
                  workoutController.showAllWorkouts();
                  createAudit(user, "Просмотрел тренировки всех пользователей");
              }
              break;
          default:
              System.out.println("Неверная команда");
              break;

      }
          System.out.println(
                  "Что делаем дальше?\n" +
                          "0 - Выйти из приложения\n" +
                          "1 - Добавить тренировку\n" +
                          "2 - Редактировать тренировку\n" +
                          "3 - Удалить тренировку\n" +
                          "4 - Вывести список тренировок\n" +
                          "5 - Вывести список всех тренировок\n"
          );




    }


}
