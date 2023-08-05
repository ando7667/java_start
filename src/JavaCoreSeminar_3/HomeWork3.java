package JavaCoreSeminar_3;

import java.util.Comparator;
import java.util.TreeSet;

import static JavaCoreSeminar_3.Worker.printWorkers;

public class HomeWork3 {
    public static void main(String[] args) {

        System.out.println("Программа работы с сотрудниками\n");
        Worker w1 = new Worker("Крылова Нина Ивановна", "1992-10-05", "секретарь", "1010", 45000.00f);
        Worker w2 = new Worker("Иванов Иван Алексеевич", "1985-07-11", "водитель", "", 48000.00f);
        Worker w3 = new Worker("Гудин Сергей Витальевич", "2000-05-25", "менеджер", "1100", 51000.00f);
        Chief c1 = new Chief("Занудин Александр Леонович", "1975-02-15", "руководитель", "1011", 80000.00f);
        Worker w4 = new Worker("Сергеева Ольга Ивановна", "2002-03-09", "менеджер", "1101", 53000.00f);
        Worker w5 = new Worker("Касьянова Елена Ф.", "2002-03-09", "менеджер", "1102", 50000.00f);
        Worker[] arr = {w1, w2, w3, c1, w4, w5};

        System.out.println("до повышения зарплаты\n");
        printWorkers(arr);
        Chief.salaryEdit(arr);
        System.out.println("после повышения зарплаты\n");
        printWorkers(arr);

        System.out.println("\nПроверим классы компаратора");

        System.out.println("\nсортировка по возрасту");
        Comparator<Worker> agecomp = new WorkerComparator.WorkerAgeComparator();
        TreeSet<Worker> workers = new TreeSet<>(agecomp);
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w5);
        workers.add(w4);
        workers.add(c1);

        for (Worker w : workers) {

            System.out.println(w.getFullName() + " " + w.getAge() + " " + w.getSalary());
        }

        System.out.println("\nсортировка по зарплате");
        Comparator<Worker> salarycomp = new WorkerComparator.WorkerSalaryComparator();
        workers = new TreeSet<>(salarycomp);
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w5);
        workers.add(w4);
        workers.add(c1);

        for (Worker w : workers) {

            System.out.println(w.getFullName() + " " + w.getAge() + " " + w.getSalary());
        }

        System.out.println("\nсортировка по возрасту и зарплате");
        Comparator<Worker> ageSalaryComp = new WorkerComparator.WorkerAgeComparator().thenComparing(new WorkerComparator.WorkerAgeComparator());
        workers = new TreeSet<>(ageSalaryComp);
        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(w5);
        workers.add(w4);
        workers.add(c1);

        for (Worker w : workers) {

            System.out.println(w.getFullName() + " " + w.getAge() + " " + w.getSalary());
        }


    }
}
