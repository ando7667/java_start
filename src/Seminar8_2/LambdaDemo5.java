package Seminar8_2;

import java.util.function.Function;

// public interface Function<T, R> {
//      R apply (T n);
//  }

public class LambdaDemo5 {
    public static void main(String[] args) {
        Function<Integer, String> convert = x -> String.valueOf(x) +  " dollars";

        System.out.println(convert.apply(34));

    }
}
