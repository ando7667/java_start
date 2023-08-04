package JavaCoreSeminar_2.tictactoe;

import java.io.*;
import java.util.Scanner;

public class FileOperation {

    static String path = "./src/JavaCoreSeminar_2/tictactoe/savegame.dat";

    public static int loadFile() {
        int pole = 0;
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                pole = scanner.nextInt();
                System.out.println("read from file - " + pole);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка чтения файла " + path);
        }
        //       }
        return pole;
    }

    /**
     * Запись значения int в файл
     *
     * @param data данные типа int для записи
     */
    public static void saveIntToFile(int data) {

        try (FileWriter writer = new FileWriter(path, false)) {
            writer.write(String.valueOf(data));
            writer.flush();
            System.out.println("\nДанные игры записаны!");
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл - " + ex.getMessage());
        }
    }
}
