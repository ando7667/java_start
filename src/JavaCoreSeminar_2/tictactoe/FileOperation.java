package JavaCoreSeminar_2.tictactoe;

import java.io.*;

public class FileOperation {

    static String path = "./src/JavaCoreSeminar_2/tictactoe/savegame.dat";

    public static int loadFile() throws IOException {
        int pole;
        try (FileInputStream inputStream = new FileInputStream(path)) {
            pole = inputStream.read();
        }
        return pole;
    }

    /**
     * Запись значения int в файл
     *
     * @param data данные типа int для записи
     */
    public static void saveIntToFile(int data) throws IOException {

        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(data);
            writer.flush();
            System.out.println("\nДанные игры записаны!");
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл - " + ex.getMessage());
        }
    }
}
