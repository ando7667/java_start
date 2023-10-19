package Java_DevKit.Lesson2.Task2;

public interface Bull {
    public  static final int amount = 2;
    default void walk() {
        System.out.println("Walks on " + amount + "hooves");
    }
    void talk();
}
