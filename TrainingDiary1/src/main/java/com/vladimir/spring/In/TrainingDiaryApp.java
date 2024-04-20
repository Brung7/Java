package com.vladimir.spring.In;

import com.vladimir.spring.Controllers.AuthController;
import com.vladimir.spring.Database.Db;
import com.vladimir.spring.Service.UsersService;
import com.vladimir.spring.Service.UsersServiceImpl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Основной класс для взаимодействия пользователя с приложением
 */
public class TrainingDiaryApp {

    public static void main(String[] args) throws ParseException {
        Db db = new Db();
        UsersService usersService = new UsersServiceImpl();
        try {
            Connection connection = db.getConnection();
            System.out.println("Connect is successfully");



        AuthController userManager = new AuthController();
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Добро пожаловать в приложение для ведения дневника тренировок!");

            System.out.println("Для начала зарегистрируйтесь:");
            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();
            while (true) {
                System.out.println("Введите роль (admin/user): ");
                String role = scanner.nextLine();
                if (role.equals("admin") || role.equals("user")) {
                    userManager.registerUser(connection,username, password, role);
                    break;
                } else {
                    System.out.println("Неврно введена роль, попробуйте ещё раз");
                }
            }


            System.out.println("--------------------------");

            if (usersService.selectUserFromTable(connection, username,password).next()) {
                System.out.println("Вы можете войти в систему.");
                System.out.println("Введите имя пользователя и пароль для входа.");

                System.out.print("Имя пользователя: ");
                String loginUsername = scanner.nextLine();
                System.out.print("Пароль: ");
                String loginPassword = scanner.nextLine();

                    if (userManager.authentication(connection,loginUsername,loginPassword)) {
                        System.out.println("Добро пожаловать, " + loginUsername + " в дневник тренировок\n" +
                                "Ознокомтесь с основными командами приложения\n" +
                                        "0 - Выйти из приложения\n" +
                                        "1 - Добавить тренировку\n" +
                                        "2 - Редактировать тренировку\n" +
                                        "3 - Удалить тренировку\n" +
                                        "4 - Вывести список тренировок\n" +
                                        "5 - Вывести список всех тренировок \n"
                        );

                            Command command = new Command();
                            int numberOfCommand;
                            //Users user = userManager.authentication(username, password);
                            do {
                                numberOfCommand = scanner.nextInt();
                                command.mainCommand(numberOfCommand,username,connection);


                            }
                            while (numberOfCommand != 0);



                    } else {
                        System.out.println("Не удалось выполнить вход. Попробуйте еще раз.");
                        continue;
                    }

                } else{
                    System.out.println("Регистрация не удалась. Попробуйте заново.");
                }
            }
        }
        catch (SQLException e){
            System.out.println("Не удалось подключится к базе данных "+ e.getMessage());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }


