package Java_DevKit.Lesson2.Task2;

public class Minotaurus implements Human, Bull {
    @Override
    public void talk() {
        System.out.println("Walks on two legs");
    }

    @Override
    public void walk() {
        System.out.println("Asks you a riddle");
    }
}
