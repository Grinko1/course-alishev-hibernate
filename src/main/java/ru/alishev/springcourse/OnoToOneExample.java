package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Item;
import ru.alishev.springcourse.model.Passport;
import ru.alishev.springcourse.model.Person;

public class OnoToOneExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            Person person = new Person("test", 99);
            Passport passport = new Passport(4444);
            person.setPassport(passport);

            session.save(person);

            session.getTransaction().commit();

        }finally {
            sessionFactory.close();
        }
    }
}
