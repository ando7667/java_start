package JavaJunior.HM1;

import java.util.*;
import java.util.stream.Stream;

/**
 * 0.1. Посмотреть разные статьи на Хабр.ру про Stream API
 * 0.2. Посмотреть видеоролики на YouTube.com Тагира Валеева про Stream API
 * <p>
 * 1. Создать список из 1_000 рандомных чисел от 1 до 1_000_000
 * 1.1 Найти максимальное
 * 2.2 Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
 * 2.3 Найти количество чисел, квадрат которых меньше, чем 100_000
 * <p>
 * 2. Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department
 * 2.1 Создать список из 10-20 сотрудников
 * 2.2 Вывести список всех различных отделов (department) по списку сотрудников
 * 2.3 Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
 * 2.4 * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
 * 2.5 * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
 */

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        // Создать список из 1_000 рандомных чисел от 1 до 1_000_000
        List<Integer> lst = Stream.generate(() -> rnd.nextInt(1, 1_000_000)).limit(1_000).toList();

        // Найти максимальное
        System.out.println("Max in lst:" + lst.stream().max(Comparator.naturalOrder()));

        // Все числа, большие, чем 500_000, умножить на 5, отнять от них 150 и просуммировать
        System.out.print("модификация и суммирование чисел, больших 500_000: ");
        System.out.println(lst.stream().filter(x -> x > 500_000).map(x -> (x * 5 - 150)).mapToLong(x -> x).sum());

        // Найти количество чисел, квадрат которых меньше, чем 100_000
        System.out.print("количество чисел, квадрат которых меньше, чем 100_000: ");
        System.out.println(lst.stream().filter(x -> (x ^ 2) < 100_000).count());

        // Создать список из 10-20 сотрудников
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < rnd.nextInt(10, 21); i++) {
            employees.add(new Employee());
        }

        // Вывести список всех различных отделов (department) по списку сотрудников
        System.out.println("список отделов: ");
        employees.stream().map(e -> e.department).distinct().forEach(System.out::println);


        // Всем сотрудникам, чья зарплата меньше 10_000, повысить зарплату на 20%
        System.out.println("Увеличим зарплату следующим сотрудникам:");
        employees.stream().filter(e -> Double.compare(e.salary, 10000) < 0).forEach(System.out::println);
        System.out.println("Зарплата повышена:");
        employees.stream().filter(e -> Double.compare(e.salary, 10000) < 0).map(e -> new Employee(e.name, e.age, e.salary * 1.2, e.department)).forEach(System.out::println);

        // * Из списка сотрудников с помощью стрима создать Map<String, List<Employee>> с отделами и сотрудниками внутри отдела
        Map<String, List<Employee>> mapEmployees = new HashMap<>();
        employees.stream().map( e -> e.department).distinct().forEach( e-> mapEmployees.put(e, new ArrayList<>()));
        employees.forEach(e -> mapEmployees.replace(e.department, add(mapEmployees.get(e.department),e)));
        System.out.println("Список сотрудников по отделам");
        for (Map.Entry<String, List<Employee>> e : mapEmployees.entrySet()) {
            System.out.println(e.getKey() + ": ");
            for (Employee i : e.getValue()) {
                System.out.println(i.toString());
            }
        }

        // * Из списока сорудников с помощью стрима создать Map<String, Double> с отделами и средней зарплатой внутри отдела
        Map<String, Double> mapSalary = new HashMap<>();
        employees.stream().map(e -> e.department).distinct().forEach( e-> mapSalary.put(e, 0.0));
        employees.forEach(e->mapSalary.replace(e.department, (mapSalary.get(e.department) + e.salary) / employees.size() ));
        System.out.println("Средняя зарплата по отделам: ");
        for (Map.Entry<String, Double> e : mapSalary.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

    }

    static List<Employee> add(List<Employee> arg, Employee val) {
        if (arg != null) {
            arg.add(val);
        }
        return arg;
    }
}
