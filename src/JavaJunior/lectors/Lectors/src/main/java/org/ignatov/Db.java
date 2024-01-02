package org.ignatov;

import java.sql.*;

public class Db {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "test1";
    private static final String PASSWORD = "1234";


    public static void conjdbc(){
        try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = con.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS `test1`;");
            statement.execute("CREATE SCHEMA IF NOT EXISTS `test1`;");
            statement.execute("CREATE TABLE `test1`.`table` (\n" +
                    " `id` INT NOT NULL,\n" +
                    " `firstname` VARCHAR(45) NULL,\n" +
                    " `lastname` VARCHAR(45) NULL,\n" +
                    " PRIMARY KEY (`id`));");
            statement.execute("INSERT INTO `test1`.`table`(`id`,`firstname`,`lastname`)\n" +
            "VALUES (1,'Иванов','Иван');");
            statement.execute("INSERT INTO `test1`.`table`(`id`,`firstname`,`lastname`)\n" +
            "VALUES (2,'Петров','Пётр');");
            ResultSet set = statement.executeQuery("SELECT * FROM `test1`.`table`;");
            while (set.next()){
                System.out.println(set.getString(3) + " " + set.getString(2) + " " + set.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void con() {

    }
}
