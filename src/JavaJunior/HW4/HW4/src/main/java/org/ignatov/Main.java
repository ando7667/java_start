package org.ignatov;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String db_url = "jdbc:mysql://localhost:3306";
        String db_user = "test1";
        String db_password = "1234";
        String db_name = "library";

        // 1. Задание
        AgentJdbc agentJdbc = new AgentJdbc(db_url, db_user, db_password);
        agentJdbc.condb();
        agentJdbc.createDB(db_name);
        agentJdbc.createTable(db_name,"book", JdbcBook.class);
        ArrayList<JdbcBook> arrBook = new ArrayList<>();

        for (int i=0; i<10;i++) {
            arrBook.add(new JdbcBook("Книга " + i, "Автор "+ i, "год "+ i));
            agentJdbc.addRecord(db_name, "book", arrBook.get(i));
        }
        agentJdbc.findRecTable(db_name, "book", "author", "Автор 7");
        agentJdbc.closedb();

        // 2. Задание
        ArrayList<HbBook> arrHBook = new ArrayList<>();
        AgentHibernate agentHibernate = new AgentHibernate();
        agentHibernate.con();

        for (int i=0; i < 10;i++) {
            arrHBook.add(new HbBook("Книга " + (i+10), "Автор "+ i, "год "+ i));
            agentHibernate.addRecTable( arrHBook.get(i));
        }

        System.out.println("\nНайдена строка:");
        agentHibernate.findRecTable(10);

        System.out.println("\nНайдены кники автора:");
        agentHibernate.findRecsTable("author", "Автор 1");

        agentHibernate.discon();

    }

}