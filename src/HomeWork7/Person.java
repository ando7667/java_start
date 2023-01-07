package HomeWork7;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

public abstract class Person {
    enum Gender {
        male, female
    }


    String firstName;
    String lastName;
    String patronymic;
    Gender gender;
    String birthday;
    int age;

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
    public Person(String first, String last, String patron, Gender gender, String birthday, int age) {
        this.firstName = first;
        this.lastName = last;
        this.patronymic = patron;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
    }

    public Person(String first) {
        this.firstName = first;
    }
    public Person() {

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

    @Override
    public String toString() {
        return String.format("<%s %s %s %s %s %d>", firstName, lastName, patronymic, gender, birthday, age);
    }

}
