package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Principal;
import ru.alishev.springcourse.model.School;

public class OneToOnePractice {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Principal.class).addAnnotatedClass(School.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            System.out.println(principal.getSchool());
            School school = session.get(School.class, 5);
            Principal principal = session.get(Principal.class, 6);
            school.setPrincipal(principal);
//            System.out.println(school.getPrincipal());
//            session.save(principal);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
