package ru.alishev.springcourse;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Item;
import ru.alishev.springcourse.model.Passport;
import ru.alishev.springcourse.model.Person;

import java.util.List;

public class OneTManyExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class).addAnnotatedClass(Passport.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            //test
            session.beginTransaction();
            Person person = session.get(Person.class, 9);
            session.getTransaction().commit();
            System.out.println("session close");

            //open session again
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("inside second session");

            person = (Person) session.merge(person);
            Hibernate.initialize(person.getItems());


            session.getTransaction().commit();
            System.out.println("get item after closing second session");
            System.out.println(person.getItems());

        } finally {
            sessionFactory.close();
        }
    }
}
