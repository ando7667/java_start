package JavaCoreSeminar_3;

public class Chief extends Worker {

    Chief(String name, String birthday, String post, String phone, float salary) {
        super(name, birthday, post, phone, salary);
    }

    static void salaryEdit(Worker[] ar) {
        for (Worker w : ar) {
            if (!w.getClass().getSimpleName().equals("Chief")) {
                w.setSalary(w.getSalary() + 5000);
            }
        }
    }
}
