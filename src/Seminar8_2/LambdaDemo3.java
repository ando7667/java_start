package Seminar8_2;

import java.util.function.Predicate;

// public interface Predicate<T>{
//      boolean test (T n)
//  }


public class LambdaDemo3 {
    public static void main(String[] args) {

        Predicate <Integer> isPredicate = x -> x > 0;
        System.out.println(isPredicate.test(5));
        System.out.println(isPredicate.test(-3));

    }
}
