package Seminar8_2;

import java.util.function.BinaryOperator;

// public interface BinaryOperator<T>{
//      T apply ( T n, T m);
//  }

public class LambdaDemo4 {
    public static void main(String[] args) {

        BinaryOperator<Integer> isBinary = (x, y) -> x * y;

        System.out.println(isBinary.apply(3, 5));
        System.out.println(isBinary.apply(13, 7));
    }
}
