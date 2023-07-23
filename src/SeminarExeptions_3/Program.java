package SeminarExeptions_3;

import java.io.IOException;

import static SeminarExeptions_3.FileOperation.saveUserToFile;
import static SeminarExeptions_3.UI.*;

public class Program {
    public static void main(String[] args) {
        String msg = "Введите данные пользователя в формате\nФамилия Имя Отчество датарождения(дд.мм.гггг) номертелефона(79991231122) пол(f|m):\n";
        User user = new User();
        String inpStr = InputString(msg);
        try {
            if (ValidatorInputString(inpStr)) {
                user.parseInputString(inpStr);
                System.out.println(user);
                saveUserToFile(user.getLastName(), user.toSaveString());
            }

        } catch (InputException e) {
            System.out.println("Ошибка Ввода! " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
