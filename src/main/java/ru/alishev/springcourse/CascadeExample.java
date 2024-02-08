package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Item;
import ru.alishev.springcourse.model.Person;

import java.util.ArrayList;
import java.util.Collections;


public class CascadeExample {
    public static void main(String[] args) {
        Configuration configuration = new org.hibernate.cfg.Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            Person person = new Person("Test cascading2", 55);
            Item item = new Item("cascade item2");
            person.setItems(new ArrayList<>(Collections.singletonList(item)));
            item.setPerson(person);
            session.save(person);

            session.getTransaction().commit();;
        }finally {
            sessionFactory.close();
        }
    }
}
