package HomeWork7;

public class Program {

    public static void main(String[] args) {

        Person irina = new Wife("Ирина");
        Person vasya = new Father("Вася");
        Person masha = new Daughter("Маша");
        Person jane = new Daughter("Женя");
        Person ivan = new Son("Иван");
        vasya.setBirthday("15.12.1975");
        vasya.setLastName("Сидоров");

        GeoTree gt = new GeoTree();

        gt.addNode(irina, GeoTree.Bonds.wife, vasya);
        gt.addNode(masha, GeoTree.Bonds.daughter, vasya);
        gt.addNode(jane, GeoTree.Bonds.daughter, vasya);
        gt.addNode(ivan, GeoTree.Bonds.son, vasya);

        System.out.println(vasya);
        System.out.println(gt.getTree());

        Research children = new Research(gt);
        System.out.println(children);

        System.out.println("Сыновья:" + Iterface.people(children.findAll(vasya, GeoTree.Bonds.son)));
        System.out.println("Дочки:" + Iterface.people(children.findAll(vasya, GeoTree.Bonds.daughter)));

    }
}
