package Java_DevKit.Lesson2.Task2;

public class Main {
    public static void main(String[] args) {
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Human man1 = new Man();
        Bull ox2 = new Ox();
        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus minos = new Minotaurus();
        Bull[] allBulls = {ox2, minos0, minos};
        Human[] allHuman = {man1, minos1, minos};

        System.out.println("Минотавр -> ");
        minos.walk();
        minos.talk();
        System.out.println("Бык -> ");
        ox2.talk();
        ox2.walk();
    }
}
