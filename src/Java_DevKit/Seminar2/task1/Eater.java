package Java_DevKit.Seminar2.task1;

public interface Eater {
    default void sleep() {
        System.out.println("default metod sleep");
    }
    void eat();
}
