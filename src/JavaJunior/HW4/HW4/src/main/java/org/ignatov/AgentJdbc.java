package org.ignatov;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;

public class AgentJdbc {
    private String url;
    private String user;
    private String password;

    public AgentJdbc(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    private Connection conn;
    public void condb() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.printf("\nПодключились к базе: %s", url);
        } catch (SQLException e) {
            System.out.printf("\nПроблема с подключением к базе: %s", url);
            System.out.println(e.getMessage());
        }
    }
    public void closedb() {
        if (conn != null) {
            try {
                conn.close();
                System.out.printf("\nОтключились от базы: %s", url);
            } catch (SQLException e) {
                System.out.println("Ошибка при отключении от базы: " + e.getMessage());
            }
        }
    }


    public void createDB(String name){
        if (conn != null && name != null) {
            try {
                Statement statement = conn.createStatement();
                statement.execute("DROP SCHEMA IF EXISTS " +  name);
                statement.execute("CREATE SCHEMA IF NOT EXISTS " +  name);
                System.out.printf("\nбаза %s создана!", name);
            } catch (SQLException e) {
                System.out.println("база не создана! -> " + e.getMessage());
            }
        }
    }

    public void createTable(String db, String table, Class object){
        if (conn != null) {
            if (table == null) table = object.getName();
            try {
                Statement statement = conn.createStatement();
                statement.execute("USE " +  db);
                statement.execute("DROP TABLE IF EXISTS " +  table);
                StringBuilder strExecute = new StringBuilder();
                strExecute.append("CREATE TABLE ").append(table).append("(");
                strExecute.append("id BIGINT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT");
                Field[] fields = object.getDeclaredFields();
                for (Field field: fields) {
                    if (typeToSqlType(field.getAnnotatedType().getType()) != null) {
                        strExecute.append(",").append(field.getName()).append(" ").append(typeToSqlType(field.getAnnotatedType().getType()));
                    }
                }
                strExecute.append(")");
                statement.execute(strExecute.toString());
                System.out.printf("\nТаблица %s создана!", table);
            } catch (SQLException e) {
                System.out.println("\nтаблица не создана! -> " + e.getMessage());
            }
        }
    }

    public void addRecord(String db, String table, Object values) {
        if (conn != null && db != null && table != null && values != null) {
            try {
                Statement statement = conn.createStatement();
                statement.execute("USE " + db);
                StringBuilder strExecute = new StringBuilder();
                strExecute.append("INSERT INTO ").append(table).append("(");
                Field[] fields = values.getClass().getDeclaredFields();
                for (Field field: fields) {
                    if (typeToSqlType(field.getAnnotatedType().getType()) != null) {
                        strExecute.append(field.getName()).append(", ");
                    }
                }
                strExecute.delete(strExecute.length() - 2, strExecute.length());
                strExecute.append(") VALUES (");
                for (Field field: fields) {

                    if (typeToSqlType(field.getAnnotatedType().getType()) != null) {
                        strExecute.append("'").append(field.get(values).toString()).append("'").append(", ");
                    }
                }
                strExecute.delete(strExecute.length() - 2, strExecute.length());
                strExecute.append(" )");
                statement.execute(strExecute.toString());
                System.out.printf("\nЗапись в таблицу %s добавлена!", table);

            } catch (SQLException | IllegalAccessException e) {
                System.out.println("\nЗапись в таблицу не добавлена! -> " + e.getMessage());
            }
        }
    }

    public void findRecTable(String db, String table, String field, String find) {
        if (conn != null && db != null && table != null && field != null) {
            try {
                String str = "";
                if (find != null) {
                    str = find;
                }
                Statement statement = conn.createStatement();
                statement.execute("USE " + db);
                StringBuilder strExecute = new StringBuilder();
                strExecute.append("SELECT * FROM " + table + " WHERE " + field + " LIKE '%" + str + "%'");
                ResultSet set = statement.executeQuery(strExecute.toString());
//                if (set == null) {
//                    System.out.println("\nЗаписи не найдены!");
 //               } else {
                    System.out.println("\nНайдены записи:");
                    while (set.next()) {
                        Long id = set.getLong("id");
                        String name = set.getString("name");
                        String author = set.getString("author");
                        String year = set.getString("year");
                        System.out.printf("\nid=%d, Книга: %s, Автор: %s, год:%s", id, name, author, year);
//                    }
                }
            } catch (SQLException e) {
                System.out.println("Что-то не так");
            }
        }
    }

    public static String typeToSqlType(Object o){
        String result = null;
        if (o.equals(Boolean.class)) result = "BIT(1)";
        if (o.equals(Byte.class)) result = "TINYINT";
        if (o.equals(Short.class)) result = "SMALLINT";
        if (o.equals(Integer.class)) result = "INT";
        if (o.equals(Long.class)) result = "BIGINT";
        if (o.equals(Float.class)) result = "FLOAT";
        if (o.equals(Double.class)) result = "DOUBLE";
        if (o.equals(String.class)) result = "VARCHAR(255)";
        return result;
    }

}
