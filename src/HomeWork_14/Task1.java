package HomeWork_14;
/*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
    необходимо повторно запросить у пользователя ввод данных.
 */

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Вы ввели число:" + inputFloatNumber());

    }

    public static float inputFloatNumber() {
        Scanner scaner = new Scanner(System.in);
        boolean numValid = false;
        float num=0;
        while (!numValid) {
            System.out.println("Введите число типа float: ");
            try {
                num = Float.parseFloat(scaner.next());
                numValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Ввели неправильные данные!\nПовторите ввод:");
            }
        }
        return num;
    }
}