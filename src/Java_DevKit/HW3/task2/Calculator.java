package Java_DevKit.HW3.task2;

public class Calculator {
    public static  <T extends Number, E extends Number> double sum(T a, E b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static  <T extends Number, E extends Number> double subtract(T a, E b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static  <T extends Number, E extends Number> double multiply(T a, E b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static  <T extends Number, E extends Number> double divide(T a, E b) {
        return a.doubleValue() / b.doubleValue();
    }


}