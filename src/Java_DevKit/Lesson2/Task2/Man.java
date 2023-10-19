package Java_DevKit.Lesson2.Task2;

public class Man implements Human{
    @Override
    public void walk() {
        System.out.println("Walk on two feet");
    }

    @Override
    public void talk() {
        System.out.println("Talks meaningful words");
    }
}
