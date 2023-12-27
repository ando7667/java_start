package org.ignatov;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.lang.module.Configuration;
import java.util.Arrays;

public class AgentHibernate {
    private Configuration config;
    private final SessionFactory sessionFactory;
    private Session session;

    AgentHibernate() {
        StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(reg).buildMetadata().buildSessionFactory();
    }

    public void con() {
        session = sessionFactory.openSession();
        System.out.println("Подключение к базе через JPA!");
    }

    public void discon() {
        session.close();
        System.out.println("Отключились от базы!");
    }

    public void addRecTable(Object obj) {
        if (session != null && obj != null) {
            Transaction transaction = session.beginTransaction();
            session.persist(obj);
            transaction.commit();
            System.out.println("Запись добавлена в таблицу ");
        }
    }

    public void findRecTable(int id){
        if (session != null) {
            System.out.println(session.get(HbBook.class, id).toString());
        }
    }
}
