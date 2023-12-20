package JavaJunior.lecture1.task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(new User("Павел", 25), new User("Аркадий", 40), new User("Валера", 30));

        list.stream().map(user -> new User(user.name, user.age - 5)).filter(user -> user.age <= 25).forEach(System.out::println);
    }
}
