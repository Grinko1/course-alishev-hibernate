package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Person;


public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

 /////////////////////////////////
            //create
/////////////////////////////////
//            Person person1= new Person("Bob", 34);
//            Person person2= new Person("Marry", 24);
//            Person person3= new Person("Alex", 34);
//            session.save(person3);
//            session.save(person2);
//            session.save(person1);


/////////////////////////////////
            //read
/////////////////////////////////
//            Person person = session.get(Person.class, 3);
//            System.out.println(person);


/////////////////////////////////
            //update
/////////////////////////////////
//            Person person = session.get(Person.class, 3);
//            person.setAge(28);
//            System.out.println(person);



/////////////////////////////////
            //delete
 /////////////////////////////////
//            Person person = session.get(Person.class, 3);
//            session.delete(person);

            session.getTransaction().commit();

            /////////////////////////////////
            //after commit object already available
            /////////////////////////////////
//            System.out.println(person3.getId());
        } finally {
            sessionFactory.close();
        }


    }
}
