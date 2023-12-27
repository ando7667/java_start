package org.ignatov;

import java.math.BigInteger;

public class JdbcBook {
    // id bigint, name varchar, author varchar
    private static int id;
    String name;
    String author;
    String year;

    /**
     *
     * @param name      - Название книги
     * @param author    - Автор
     * @param year      - год издания
     */
    public JdbcBook(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
        id++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static int getId() {
        return id;
    }
}
