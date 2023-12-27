package org.ignatov;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String db_url = "jdbc:mysql://localhost:3306";
        String db_user = "test1";
        String db_password = "1234";
        String db_name = "library";


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

    }
}