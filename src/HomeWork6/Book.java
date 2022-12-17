package HomeWork6;

public class Book {
    public String nameBook;
    public String authorBook;

    /**
     * Ввод книги
     *
     * @param nameBook   Название книги
     * @param authorBook Автор
     */
    public Book(String nameBook, String authorBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
    }

    public String getNameBook() {
        return this.nameBook;
    }

    public String getAuthorBook() {
        return this.authorBook;
    }
}
