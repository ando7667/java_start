package Seminar7_4;

import Seminar7_3.MyClass;

public class Program {
    public static void main(String[] args) {
        DefMyClass obj = new DefMyClass();

        //  статические методы не наследуются не классами не интерфейсами
        //  обращаемся к статическим методам только через имя интерфейса и имя метода

        //  использование статического метода ( без создания объекта )
        int uid = DefaultM.getUniversalId();

        System.out.println("Id пользователя " + obj.getUserId());
        System.out.println("Id админа " + obj.getAdminId());
        System.out.println("Id универсальный " + uid);
    }
}
