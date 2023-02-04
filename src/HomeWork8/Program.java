package HomeWork8;


import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(LogManager.class.getName());
        LogManager.getLogManager().readConfiguration(Program.class.getResourceAsStream("logging.properties"));
//        log.log(new LogRecord(Level.INFO, "Запуск программы"));
        log.log(Level.INFO, "Запуск программы");

        Menu m = new Menu();
        Calculator calculator = new Calculator();
        while (true) {
            m.showMenu();
            // если выбрали режим 0 - выход из программы
            if (m.getMode() == 0) {
                System.out.println("Пока!");
                log.log(Level.INFO, "Выход из программы");
                break;
            } else {
                System.out.println("Введите первое число: ");
                double firstNum = m.getNumber();
                System.out.println("Введите второе число: ");
                double secondNum = m.getNumber();
                double result = calculator.makeCalculation(firstNum, secondNum, m.getAction());
                log.log(Level.INFO, "Были введены следующие параметры: mode: "+m.getMode()+", action: "+m.getAction()+", 1e число:"+firstNum+", 2e число: "+secondNum+", Результат:"+result);
                System.out.println("Результат = " + result);
               // break;
            }
        }
    }
}
