package JavaJunior.HM1;

// Создать класс Employee (Сотрудник) с полями: String name, int age, double salary, String department

import java.util.Random;

public class Employee {
    private static int count = 0;
    private static final Random rnd = new Random();
    String name;
    int age;
    double salary;
    String department;

    public Employee() {
        count++;
        this.name = "Employee" + count;
        this.age = rnd.nextInt(20, 55);
        this.salary = rnd.nextInt(5000, 100000);
        this.department = "Department_" + rnd.nextInt(1, 5);
    }

    public Employee(String name, int age, double salary, String dep) {
        count++;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = dep;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Salary: %f, Department: %s", this.name, this.age, this.salary, this.department);
    }
}
