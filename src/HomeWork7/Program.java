package HomeWork7;

public class Program {

    public static void main(String[] args) {

        Female irina = new Female("Ирина");
        Male vasya = new Male("Вася");
        Female masha = new Female("Маша");
        Female jane = new Female("Женя");
        Male ivan = new Male("Ваня");
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
