package HomeWork7;

import Seminar9_1.TwoGen;

import java.util.Iterator;

public class Program {

    public static void main(String[] args) {

        // тестируем обобщения
        Optional<String, Integer> par1 = new Optional<>("Количество детей", 3);
        Person irina = new Wife("Ирина", par1);
        Optional<String, String> par2 = new Optional<>("Цвет глаз", "Голубой");
        Person vasya = new Father("Вася", par2);
        Optional<String, Integer> par4 = new Optional<>("Количество зубов", 34);
        Person masha = new Daughter("Маша", par4);
        Optional<String, String> par5 = new Optional<>("Цвет волос", "Золотистый");
        Person jane = new Daughter("Женя", par5);
        Optional<String, String> par3 = new Optional<>("Цвет волос", "Каштановые");
        Person ivan = new Son("Иван", par3);

        vasya.setBirthday("15.12.1975");
        vasya.setLastName("Сидоров");
        vasya.setAge(50);
        irina.setAge(40);

        GeoTree gt = new GeoTree();

        gt.addNode(irina, GeoTree.Bonds.wife, vasya);
        gt.addNode(masha, GeoTree.Bonds.daughter, vasya);
        gt.addNode(jane, GeoTree.Bonds.daughter, vasya);
        gt.addNode(ivan, GeoTree.Bonds.son, vasya);

        System.out.println(vasya);
        System.out.println(gt.getTree());

        Research findResult = new Research(gt);

        System.out.println("Сыновья: " + Iterface.people(findResult.findAll(vasya, GeoTree.Bonds.son)));
        System.out.println("Дочки: " + Iterface.people(findResult.findAll(vasya, GeoTree.Bonds.daughter)));
        System.out.println("Жена: " + Iterface.people(findResult.findAll(vasya, GeoTree.Bonds.wife)));

        System.out.println("\nИспользование стандартного интерфейса Iterator");
        System.out.println("Выводим поля и значение полей экземпляра vasya класса Father \n");

        // вывод значения полей экземпляров классов
        vasya.showFields();
        irina.showFields();

    }
}
