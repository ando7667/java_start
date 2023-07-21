package JavaCoreSeminar_3;

import java.util.Comparator;

public class WorkerComparator {

    public static class WorkerAgeComparator implements Comparator<Worker> {

        public int compare(Worker w1, Worker w2) {
            return Integer.compare(w1.getAge(), w2.getAge());
        }

    }

    public static class WorkerSalaryComparator implements Comparator<Worker> {

        public int compare(Worker w1, Worker w2) {
            return Float.compare(w1.getSalary(), w2.getSalary());
        }

    }

}
