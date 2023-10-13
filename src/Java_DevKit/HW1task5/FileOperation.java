package Java_DevKit.HW1task5;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileOperation {

    private static final String path = "./src/Java_DevKit/HW1task5/Log/log_chat.txt";
    /**
     * Запись строки данных в файл
     *
     * @param data     строка данных для записи
     */
    public static void saveChatToFile(String data) throws IOException {
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.write(data);
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл - " + ex.getMessage());
        }

    }

    public static String loadChatFromFile() throws IOException {
        List<String> data = Files.readAllLines(Paths.get(path));
        return String.join(System.lineSeparator(), data);
    }
}
