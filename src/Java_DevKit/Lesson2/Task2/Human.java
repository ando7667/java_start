package Java_DevKit.Lesson2.Task2;

public interface Human {
    default void walk() {
        System.out.println("Walks on two feet");
    }
    void talk();
}
