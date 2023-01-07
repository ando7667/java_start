package Seminar8_2;

import java.util.function.Consumer;

public class LambdaDemo6 {
    public static void main(String[] args) {
        Consumer<Integer> printer = x -> System.out.printf("%d dollars \n" , x);
        printer.accept(600);
    }
}
