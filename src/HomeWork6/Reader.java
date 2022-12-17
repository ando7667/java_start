// ===================================================================================================
// Урок 6. Хранение и обработка данных ч3: множество коллекций Set
// Сдавать код на гитхабе, само задание - здесь https://pastebin.com/ns2gM2Py

// Определить класс Reader, хранящий такую информацию о пользователе библиотеки:
// 1.ФИО,
// 2.номер читательского билета,
// 3.факультет,
// 4.дата рождения,
// 5.телефон.
// 6.Методы (экземпляра, без слова static) takeBook(), returnBook().
// 7.Разработать программу, в которой создается массив объектов данного класса.
// 8.Перегрузить методы takeBook(), returnBook():
// 9.takeBook, который будет принимать количество взятых книг.
//    Выводит на консоль сообщение "Петров В. В. взял 3 книги".
// 10.takeBook, который будет принимать переменное количество названий книг.
//    Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
// 11.takeBook, который будет принимать переменное количество (Тип... parameterName) объектов
//    класса Book (создать новый класс, содержащий имя и автора книги).
//    Выводит на консоль сообщение "Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".
// 12.Аналогичным образом перегрузить метод returnBook().
//    Выводит на консоль сообщение "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
//    Или "Петров В. В. вернул 3 книги".
//-----------------------------------------------------------------------------------------------------

package HomeWork6;

public class Reader {
    public String surname;
    public String name;
    public String patronymic;
    public String ticketNumber;
    public String faculty;
    public String birthday;
    public String phone;

    /**
     * создание Читателя
     *
     * @param surname      фамилия
     * @param name         имя
     * @param patronymic   отчество
     * @param ticketNumber номер читательского билета
     * @param faculty      факультет
     * @param birthday     дата рождения
     * @param phone        телефон
     */
    public Reader(String surname, String name, String patronymic, String ticketNumber, String faculty, String birthday, String phone) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.ticketNumber = ticketNumber;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %s, %s, %s\n", this.surname, this.name, this.patronymic, this.ticketNumber, this.birthday, this.faculty, this.phone);
    }

    void takeBook() {
        System.out.printf("%s %s.%s. взял книгу%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0));
    }

    void takeBook(int countBook) {
        System.out.printf("%s %s.%s. взял %s  книги%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0), countBook);
    }

    void takeBook(String... nameBook) {
        StringBuilder sb = new StringBuilder();
        for (String number : nameBook) {
            sb.append(number + ", ");
        }
        System.out.printf("%s %s.%s. взял книги: %s%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0), sb);
    }

    void takeBook(Book... books) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.getNameBook()).append(", ");
        }
        System.out.printf("%s %s.%s. взял книги: %s%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0), sb);

    }

    void returnBook() {
        System.out.printf("%s %s.%s. сдал книгу%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0));
    }

    void returnBook(int countBook) {
        System.out.printf("%s %s.%s. сдал %s  книги%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0), countBook);
    }

    void returnBook(String... nameBook) {
        StringBuilder sb = new StringBuilder();
        for (String number : nameBook) {
            sb.append(number).append(", ");
        }
        System.out.printf("%s %s.%s. сдал книги: %s%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0), sb);
    }

    void returnBook(Book... books) {
        StringBuilder sb = new StringBuilder();
        for (Book book : books) {
            sb.append(book.getNameBook()).append(", ");
        }
        System.out.printf("%s %s.%s. сдал книги: %s%n", this.surname, this.name.charAt(0), this.patronymic.charAt(0), sb);

    }

}
