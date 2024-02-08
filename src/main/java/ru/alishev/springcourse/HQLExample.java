package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Person;

import java.util.List;

public class HQLExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

           session.createQuery("delete from Person where age<30").executeUpdate();
//            System.out.println(people);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
