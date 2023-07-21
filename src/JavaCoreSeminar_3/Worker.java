package JavaCoreSeminar_3;

import java.time.LocalDate;
import java.time.Period;

public class Worker {
    private static int id = 0;

    public int uid;
    private String fullName;
    private String birthday;
    private String post;

    private String phone;

    private float salary;

    Worker(String name, String birthday, String post, String phone, float salary) {
        this.fullName = name;
        this.birthday = birthday;
        this.post = post;
        this.phone = phone;
        this.salary = salary;
        this.uid = ++id;
    }

    public int getUid() {
        return uid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getPost() {
        return post;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        LocalDate bday = LocalDate.parse(birthday);
        if (bday != null) {
            return Period.between(bday, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setSalary(float val) {
        this.salary = val;
    }

    @Override
    public String toString() {
        return String.format("id:%d, ФИО:%s, дата рождения:%s, возраст:%d, должность:%s, телефон:%s зарплата:%.2f == класс:%s", this.getUid(), this.getFullName(), this.getBirthday(), this.getAge(), this.getPost(), this.getPhone(), this.getSalary(), getClass().getSimpleName());
    }

    public static void printWorkers(Worker[] ar) {
        for (Worker w : ar) {
            System.out.println(w.toString());
        }
    }
}
