package Seminar7_4;

public interface DefaultM {
    int getUserId();

    default int getAdminId() {  // метод по-умолчанию используется , если данный метод не буд реализван в классе наследования интерфейса
        return 1;
    }

    // объявление статического метода
    static  int getUniversalId() {
        return 33;
    }
}
