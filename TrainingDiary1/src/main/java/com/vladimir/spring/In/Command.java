package com.vladimir.spring.In;
import com.vladimir.spring.Controllers.AuthController;
import com.vladimir.spring.Controllers.WorkoutController;
import com.vladimir.spring.Models.Audit;
import com.vladimir.spring.Models.Users;
import com.vladimir.spring.Models.Workout;
import com.vladimir.spring.Storage.AuditStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Класс с основными командами для взаимодействия пользователя с приложением
 */
public class Command {
    WorkoutController workoutController = new WorkoutController();

    AuthController authController = new AuthController();
    AuditStorage auditStorage = new AuditStorage();




    public void mainCommand(int command, String username, Connection connection) throws ParseException, SQLException {
        Scanner scanner = new Scanner(System.in);
      switch (command){
          case 0:
             String actionExit = "Выход из приложения";
             auditStorage.logAudit(connection,username,actionExit);
              break;
       case 1:
            workoutController.addWorkoutToUser(username, connection);
           String actionAdd = "Добавил тренировку";
           auditStorage.logAudit(connection,username,actionAdd);
              break;
         case 2:
              System.out.println("Введите id тренировки, которую хотите изменить");
              workoutController.printAllUserWorkout(connection,username);
              int workoutId = scanner.nextInt();
              workoutController.editUserWorkout(connection,workoutId);
                String actionEdit = "Изменил тренировку";
                auditStorage.logAudit(connection,username,actionEdit);

              break;
          case 3:
              workoutController.printAllUserWorkout(connection,username);
              System.out.println("Введите номер тренировки,которую хотите удалить");
              int indexToRemove = scanner.nextInt();
              workoutController.deleteWorkout(connection,indexToRemove);
              String actionDel = "Удалил тренировку";
              auditStorage.logAudit(connection,username,actionDel);
              break;
          case 4:
              System.out.println("Вывод всех тренировок конкретного пользователя");
              workoutController.printAllUserWorkout(connection,username);
              String actionShow = "Просмотрел свои тренировки";
              auditStorage.logAudit(connection,username,actionShow);
              break;
          case 5:
              if(!authController.isAdmin(connection, username)) {
                  System.out.println("Это команда доступна только администратору");
              }
              else {
                  System.out.println("Вывод всех тренировок всех пользователей");
                  workoutController.ShowAllWorkoutsAllUsers(connection);
                  String actionShowAll = "Просмотрел все тренировки";
                  auditStorage.logAudit(connection,username,actionShowAll);
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
