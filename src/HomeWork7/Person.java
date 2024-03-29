package HomeWork7;

import java.util.Iterator;
import java.util.UUID;

public abstract class Person <T, U> implements Iterator<String> {

    enum Gender {
        male, female
    }

    // генерация строкового идентификатора
    // вызывается из конструктора класса (при создании экземпляра класса)
    private String genuid() {
        return UUID.randomUUID().toString();
    }

    String uidPerson;
    String firstName;
    String lastName;
    String patronymic;
    Gender gender;
    String birthday;
    int age;
    Optional optional;

    /**
     * создание Персоны
     *
     * @param first    имя
     * @param last     фамилия
     * @param patron   отчество
     * @param gender   пол
     * @param birthday дата рождения
     * @param age      возраст
     */
    public Person(String first, String last, String patron, Gender gender, String birthday, int age, Optional<T, U> opt) {
        this.uidPerson = genuid();
        this.firstName = first;
        this.lastName = last;
        this.patronymic = patron;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.optional = new Optional<T, U>(opt.param1, opt.param2);
    }

    public String getUidPerson() {
        return uidPerson;
    }

    public Person() {
        this.uidPerson = genuid();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return this.firstName;
    }

    // переопределяем методы hasNext() и next() интерфейса Iterator для нашего класса
    int index;

    @Override
    public boolean hasNext() {
        return index++ < 8;
    }

    @Override
    public String next() {
        switch (index) {
            case 1:
                //return uidPerson;
                return String.format("uidPerson: %s", uidPerson);
            case 2:
                //return firstName;
                return String.format("firstName: %s", firstName);
            case 3:
                //return lastName;
                return String.format("lastName: %s", lastName);
            case 4:
                //return age;
                return String.format("patronymic: %s", patronymic);
            case 5:
                //return gender;
                return String.format("gender: %s", gender);
            case 6:
                //return birthday;
                return String.format("birthday: %s", birthday);
            case 7:
                //return age;
                return String.format("age: %d", age);
            default:
                //return opt;
                if (optional != null) {
                    return String.format("optional: %s - %s", optional.param1, optional.param2);
                }
                return String.format("optional: %s - %s", "не задано", "не задано");
        }
    }

    @Override
    public String toString() {
        return String.format("<%s %s %s %s %s %s %d %s %s>", getUidPerson(), firstName, lastName, patronymic, gender, birthday, age, optional.param1, optional.param2);
    }

    public void showFields(){
        Iterator<String> fl = this;
        while (fl.hasNext()) {
            System.out.println(fl.next());
        }

    }

}
