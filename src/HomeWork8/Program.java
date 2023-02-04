package HomeWork8;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Program {

    public static void main(String[] args) throws IOException {
        // инициализируем логгер
        Logger log = Logger.getLogger(LogManager.class.getName());
        // читаем настройки логера из файла logging.properties
        LogManager.getLogManager().readConfiguration(Program.class.getResourceAsStream("logging.properties"));
        log.log(Level.INFO, "Запуск программы");

        // инициализируем меню и калькулятор
        Menu m = new Menu();
        Calculator calculator = new Calculator();

        // бесконечный цикл по меню, пока не выберем режим = 0
        while (true) {
            // вызов меню
            m.showMenu();
            // если выбрали режим 0 - выход из программы
            if (m.getMode() == 0) {
                System.out.println("Пока!");
                log.log(Level.INFO, "Выход из программы");
                break;
            } else {
                // если задали режим работы и операцию, то вводим числа и вычисляем
                System.out.println("Введите первое число: ");
                double firstNum = m.getNumber();
                System.out.println("Введите второе число: ");
                double secondNum = m.getNumber();
                // вызов калькулятора
                double result = calculator.makeCalculation(firstNum, secondNum, m.getAction());
                // вывод результата с введенными данными в систему логирования ( исходя из настроек - в файл )
                log.log(Level.INFO, "Были введены следующие параметры: mode: " + m.getMode() + ", action: " + m.getAction() + ", 1e число:" + firstNum + ", 2e число: " + secondNum + ", Результат:" + result);
                System.out.println("Результат = " + result);
            }
        }
    }
}
