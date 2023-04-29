package HomeWork_14;
/*
    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
*/
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Вы ввели строку:" + inputString());
    }

    public static String inputString() {
        Scanner scaner = new Scanner(System.in);
        boolean numValid = false;
        String str= null;
        while (!numValid) {
            System.out.println("Введите строку: ");
                str = scaner.nextLine();
                if (str == ""){
                    System.out.println("Строка не должна быть пустой!");
                    throw new RuntimeException("Ввод пустой строки!!!");
                }else {
                    numValid = true;
                }
        }
        return str;
    }
}
