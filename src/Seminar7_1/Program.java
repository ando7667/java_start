package Seminar7_1;

public class Program {
    public static void main(String[] args) {
        RealNums obj = new RealNums();
        RealNums_1 obj_1 = new RealNums_1();
        Nums obi;           // объявляем переменную obi как ссылку на интерфейс Nums

        for (int i = 0; i < 5; i++) {
            obi = obj;   // заносим ссылку на класс obj в переменную obi
            System.out.println("Следующее значение: " + obi.getNext());
        }
        for (int i = 0; i < 5; i++) {
            obi = obj_1;
            System.out.println("Следующее значение: " + obi.getNext());
        }

    }
}
