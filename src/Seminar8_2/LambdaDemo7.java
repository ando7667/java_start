package Seminar8_2;

import java.util.Scanner;
import java.util.function.Supplier;

// public interface Supplier<T> {
//      T get();
//  }


public class LambdaDemo7 {
    public static void main(String[] args) {

        Supplier<User> userFacory = () -> {
            Scanner in = new Scanner(System.in);
            System.out.println("введите имя ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFacory.get();
        User user2 = userFacory.get();

        System.out.println("имя user1 :" + user1.getName());
        System.out.println("имя user2 :" + user2.getName());
    }
}
