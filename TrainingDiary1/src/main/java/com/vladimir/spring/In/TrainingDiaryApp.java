package com.vladimir.spring.In;

import com.vladimir.spring.Controllers.AuthController;
import com.vladimir.spring.Models.Users;

import java.text.ParseException;
import java.util.Scanner;

public class TrainingDiaryApp {


    public static void main(String[] args) throws ParseException {
        AuthController userManager = new AuthController();
        //Регистрация пользователя
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Добро пожаловать в приложение для ведения дневника тренировок!");

            System.out.println("Для начала зарегистрируйтесь:");
            System.out.print("Введите имя пользователя: ");
            String username = scanner.nextLine();
            System.out.print("Введите пароль: ");
            String password = scanner.nextLine();
            while (true){
            System.out.println("Введите роль (admin/user): ");
            String role = scanner.nextLine();
            if(role.equals("admin")||role.equals("user")) {
                userManager.registerUser(username, password, role);
                break;
            }
            else {
                System.out.println("Неврно введена роль, попробуйте ещё раз");
            }
            }


            //Проверка на регистрацию
            if (username != null) {
                System.out.println("Теперь вы можете войти в систему.");
                System.out.println("Введите имя пользователя и пароль для входа.");

                System.out.print("Имя пользователя: ");
                String loginUsername = scanner.nextLine();
                System.out.print("Пароль: ");
                String loginPassword = scanner.nextLine();

                Users loggedInUser = userManager.authentication(loginUsername, loginPassword);
                    if (loggedInUser != null) {
                        System.out.println("Добро пожаловать, " + username + " в дневник тренировок\n");
                        // Работа с дневником
                        System.out.println(
                                "Ознокомтесь с основными командами приложения\n" +
                                        "0 - Выйти из приложения\n" +
                                        "1 - Добавить тренировку\n" +
                                        "2 - Редактировать тренировку\n" +
                                        "3 - Удалить тренировку\n" +
                                        "4 - Вывести список тренировок\n" +
                                        "5 - Вывести список всех тренировок \n"
                        );

                        //Проверка на роль пользователя
                        //Работа с пользователем admin
                        if ("admin".equals(userManager.getRole(username))) {
                            AdminCommand adminCommand = new AdminCommand();
                            int numberOfCommand;
                            Users user = userManager.authentication(username, password);
                            do {
                                numberOfCommand = scanner.nextInt();
                                adminCommand.adminCommand(numberOfCommand, user);
                            } while (numberOfCommand != 0);


                        }
                        //Работа с пользователем user
                        if ("user".equals(userManager.getRole(username))) {
                            Command command = new Command();
                            int numberOfCommand;
                            Users user = userManager.authentication(username, password);
                            do {
                                numberOfCommand = scanner.nextInt();
                                command.mainCommand(numberOfCommand, user);


                            }
                            while (numberOfCommand != 0);
                        }


                    } else {
                        System.out.println("Не удалось выполнить вход. Попробуйте еще раз.");
                        continue;
                    }

                } else{
                    System.out.println("Регистрация не удалась. Попробуйте заново.");
                }
            }
        }

    }


