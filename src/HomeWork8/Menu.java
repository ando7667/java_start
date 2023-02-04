package HomeWork8;

import java.util.Scanner;


public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private int mode;   // режима работы калькулятора
    private int action; // опреция над числами

    public Menu() {
        this.mode = 0;
        this.action = 0;
    }

    public int getMode() {
        return mode;
    }

    public int getAction() {
        return action;
    }

    // массив строк меню выбора режима работы калькулятора
    private String[] arr_mode = new String[]{
            "Выход",
            "для обычных чисел",
            "для комплексных чисел"
    };

    // массив строк меню выбора опреции над числами
    private String[] arr_action = new String[]{
            "Назад",
            "Сложение",
            "Вычитание",
            "Умножение",
            "Деление"
    };

    // вывод массива строк на экран в виде меню
    private void showText(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " - " + arr[i]);
        }
    }

    // получить число от пользователя
    public double getNumber() {
        double num;
        if (scanner.hasNextDouble()) {
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next(); //рекурсия до правильного ввода
            num = getNumber();
        }
        return num;
    }

    // установка режима работы калькулятора
    private void setMode() {
        while (true) {
            System.out.println("Задайте режим вычислений:");
            showText(arr_mode);
            mode = (int) getNumber();
            // проверяем выход за пределы существующих режимов
            if (mode < arr_mode.length && mode >= 0) {
                break;
            }
        }
    }

    // установка операции над числами
    private void setAction() {
        while (true) {
            System.out.println("Выберите операцию:");
            showText(arr_action);
            action = (int) getNumber();
            // проверяем выход за пределы существующих операций
            if (action < arr_action.length && action >= 0) {
                break;
            }
        }
    }

    // пройтись по меню и выбрать режим и операцию
    public void showMenu() {

        setMode();
        if (mode != 0) {
            setAction();
            if (action == 0) {
                showMenu();
            }
        }
    }
}
