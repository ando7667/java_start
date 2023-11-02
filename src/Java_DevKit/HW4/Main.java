package Java_DevKit.HW4;

/* --------------------------------------------------------------------------
* Создать класс справочник сотрудников,
* который содержит внутри коллекцию сотрудников.
* Каждый сотрудник должен иметь следующие атрибуты:
*    Табельный номер
*    Номер телефона
*    Имя
*    Стаж
* Добавить метод, который ищет сотрудника по стажу (может быть список)
* Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
* Добавить метод, который ищет сотрудника по табельному номеру
* Добавить метод добавления нового сотрудника в справочник сотрудников
* --------------------------------------------------------------------------- */

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static int getNumber() {
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next(); //рекурсия до правильного ввода
            num = getNumber();
        }
        return num;
    }

    private static int inputInt(String msg) {
        int inp;
        while (true) {
            System.out.println(msg);
            inp = (int) getNumber();
            if (inp > 1 && inp <= 100) {
                break;
            }
        }
        return inp;
    }

    static void printLine() {
        System.out.println("------------------------------------------");
    }
    public static void main(String[] args) {

        var pl = new EmployeeHandbook();
        pl.add("91611155", "Владимир", 3);
        pl.add("9032244", "Олег", 2);
        pl.add("9032200", "Ольга", 7);
        pl.add("4951568899", "Алексей", 10);
        pl.add("18355941", "Катя", 4);
        pl.add("1112597", "Олеся", 8);
        pl.add("1169825647", "Александр", 15);
        pl.add("1597354", "Андрей", 3);
        pl.add("1597354", "Алексей", 9);
        pl.add("133455941", "Катя", 2);

        System.out.println("Список всех сотрудников:\n");
        pl.forEach();
        printLine();
        int stand = inputInt("Введите стаж для поиска сотрудника: ");

        Person pers = pl.findByStanding( stand);
        if (pers == null) {
            System.out.printf("Сотрудник со стажем %d не найден!\n", stand);
        } else {
            System.out.printf("Сотрудник со стажем %d: %s\n", stand, pers);
        }
        printLine();
        System.out.printf("посмотрим всех сотрудников со стажем %d:\n", stand);
        pl.printFindStandingAll(stand);
        printLine();
        var phone = pl.findPhonesByName("Катя");
        System.out.println("У сотрудника(ов) по имени Катя номер телефона: " + phone);
        printLine();
        stand = inputInt("Введите Табельный номер для поиска сотрудника(1-100): ");
        pers = pl.findPersonByEmployee(stand);
        if (pers == null) {
            System.out.printf("сотрудника с табельным номером %d не наден!\n", stand);
        }else {
            System.out.println(pers);
        }
        printLine();
        var employeesByName = pl.findSomething( p -> p.getName().equals("Алексей"), Person::getEmployeeNumber);
        System.out.println("Сотрудники с именем Алексей имеют табельные номера: " + employeesByName);
    }

}
