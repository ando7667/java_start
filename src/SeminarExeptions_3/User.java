package SeminarExeptions_3;

import static SeminarExeptions_3.UI.*;

public class User {

    private String lastName;
    private String name;
    private String middleName;
    private String birthday;
    private long phone;
    private char gender;

    public User() {
        this.lastName = null;
        this.name = null;
        this.middleName = null;
        this.birthday = null;
        this.phone = 0;
        this.gender = '.';
    }

    public User(String lastName, String name, String middleName, String birthday, int phone, char gender) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.birthday = birthday;
        this.phone = phone;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Парсит строку в поля класса
     *
     * @param inpStr строка для парсинга
     */
    void parseInputString(String inpStr) {
        String[] inpData = inpStr.split(" ");
        this.setLastName(checkString(inpData[0]));
        this.setName(checkString(inpData[1]));
        this.setMiddleName(checkString(inpData[2]));
        this.setBirthday(checkValidDate(inpData[3]));
        this.setPhone(checkInt(inpData[4]));
        this.setGender(checkChar(inpData[5]));
    }

    @Override
    public String toString() {
        return String.format("\nФамилия: %s,\nИмя:%s,\nОтчество:%s,\nДата рождения:%s,\nтелефон:%d,\nпол:%s;", getLastName(), getName(), getMiddleName(), getBirthday(), getPhone(), getGender());
    }

    /**
     * Формирование строки для записи в файл
     * @return строка для записи
     */
    public String toSaveString() {
        return String.format("<%s><%s><%s><%s> <%d><%s>\n", getLastName(), getName(), getMiddleName(), getBirthday(), getPhone(), getGender());
    }
}
