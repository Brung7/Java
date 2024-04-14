package com.vladimir.spring.Out;

/**
 * Класс для вывода сообщений в консоль
 */
public class Out {


    public void enterTraining(){
        System.out.println("Добавить тренировку");
        System.out.println("Введите данные о тренировке");
    }

    public void enterDateOfTraining(){
        System.out.println("Введите дату тренировки (dd/MM/yyyy)");
    }
    public void enterTimeOfTraining(){
        System.out.println("Время тренировки");
    }
    public void enterCalories(){
        System.out.println("Количество калорий");
    }
    public void enterCountEx(){
        System.out.println("Количество упражнений");
    }
    public void enterCountOfSteps(){
        System.out.println("Количество шагов");
    }
    public void enterTypeOfTraining(){
        System.out.println("Тип тренировки");
    }
}
