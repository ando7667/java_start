package Java_DevKit.Seminar2.task1;

public class Animal implements Runnable, Eater{
    @Override
    public void run() {
        System.out.println("metod run of Animals class");
    }

    @Override
    public void eat() {
        System.out.println("metod eat of Animals class");
    }
}
