package HomeWork6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    static List<Reader> readers = new ArrayList<>();

    // генерация случайных данных и формирование массива из объектов Reader
    public static void generatorReaders(String[] surname, String[] nameM, String[] faculty, int count) {
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            String surn = surname[rand.nextInt(surname.length)];
            String name = nameM[rand.nextInt(nameM.length)];
            String patron = nameM[rand.nextInt(nameM.length)] + "ович";
            String tick = Integer.toString(rand.nextInt(100000, 199999));
            String facult = faculty[rand.nextInt(faculty.length)];
            String phone = "8916" + rand.nextInt(1001010, 9999999);
            String bday = "" + rand.nextInt(1, 28) + '.' + rand.nextInt(1, 12) + '.' + rand.nextInt(1960, 2002);
            readers.add(new Reader(surn, name, patron, tick, facult, bday, phone));
        }
    }

    // вывод массива объектов Reader в консоль
    public static void showReaders(List<Reader> readers) {
        for (Reader reader : readers) {
            System.out.println(reader.toString());
        }
    }


    public static void main(String[] args) {

        // создадим массивы для генератора Читателей
        String[] surname = {"Петров", "SeminarExeptions_3/Иванов", "Сидоров", "Касьянов", "Лепешкин"};
        String[] nameM = {"Александр", "Иван", "Олег", "Кирил", "Антон", "Захар", "Станислав"};
        String[] faculty = {"физики", "математики", "химии", "ин.языков", "строительный"};

        // количество записей для массива из объектов Reader
        int countReaders = 10;

        // генерируем массив Читателей
        generatorReaders(surname, nameM, faculty, countReaders);

        // вывод в консоль всех Читателей
        showReaders(readers);

        readers.get(5).takeBook(6);
        readers.get(2).takeBook("Приключения, Словарь, Энциклопедия");

        // создадим экзепляры класса Book
        Book book1 = new Book("Приключения", "Ефремов И.А.");
        Book book2 = new Book("Словарь", "Даль В.И.");
        Book book3 = new Book("Энциклопедия", "Жуков Е.М.");

        readers.get(1).takeBook(book1, book2, book3);
        readers.get(3).returnBook(2);
        readers.get(4).returnBook("Словарь, Энциклопедия");
        readers.get(7).returnBook(book2);

    }
}
