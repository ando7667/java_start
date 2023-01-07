package Seminar7_4;

public class DefMyClass implements DefaultM {

    @Override
    public int getUserId() {
        return 100;
    }

    // если убрать данный метод, то будет браться метод из интерфейса по-умолчанию
    @Override
    public int getAdminId() {
        return 3;
    }
}
