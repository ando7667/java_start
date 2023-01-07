package HomeWork7;

import java.util.Iterator;

public class Program {

    public static void main(String[] args) {

        Person irina = new Wife("Ирина");
        Person vasya = new Father("Вася");
        Person masha = new Daughter("Маша");
        Person jane = new Daughter("Женя");
        Person ivan = new Son("Иван");
        vasya.setBirthday("15.12.1975");
        vasya.setLastName("Сидоров");
        vasya.setAge(50);

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
        Iterator<String> fields = vasya;
        while (fields.hasNext()) {
            System.out.println(vasya.next());
        }

    }
}
