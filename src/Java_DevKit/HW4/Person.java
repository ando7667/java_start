package Java_DevKit.HW4;

public class Person {
    int employeeNumber;
    String phone;
    String name;
    int standing;

    /**
     *
     * @param number - табельный номер сотрудника
     * @param phone - телефон сотрудника
     * @param name - имя сотрудника
     * @param standing - стаж сотрудника
     */
    public Person(int number, String phone, String name, int standing) {
        this.employeeNumber = number;
        this.phone = phone;
        this.name = name;
        this.standing = standing;
    }


    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getStanding() {
        return standing;
    }

    @Override
    public String toString() {
        return String.format("Табель: %d, Имя: %s, Телефон: %s, Стаж: %d", employeeNumber, name, phone, standing);
    }

}
