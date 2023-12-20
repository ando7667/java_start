package JavaJunior.lecture1.task2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Привет", "Мир", "!", "я", "родился", "!");

//        list = list.stream().filter(str -> str.length() > 4).collect(Collectors.toList());
//
//        for(String item: list) {
//            System.out.println(item);
//        }

        list.stream().filter(str -> str.length() > 4).filter(str->str.contains("о")).forEach(System.out::println);

//        Arrays.asList(1,10,0,7,5).stream().map(chislo -> "число: " + chislo + ". квадрат числа - " + chislo * chislo).forEach(System.out::println);
        Arrays.asList(1,10,5,0,7,5).stream().sorted().distinct().forEach(System.out::println);
    }
}
