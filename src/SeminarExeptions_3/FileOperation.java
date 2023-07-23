package SeminarExeptions_3;

import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
    /**
     * Запись строки данных в файл
     *
     * @param filename имя файла для записи
     * @param data     строка данных для записи
     */
    public static void saveUserToFile(String filename, String data) throws IOException {

        String path = "./src/SeminarExeptions_3/";
        try (FileWriter writer = new FileWriter(path + filename, true)) {
            writer.write(data);
            writer.flush();
            System.out.println("\nДанные записаны!");
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл - " + ex.getMessage());
        }

    }
}
