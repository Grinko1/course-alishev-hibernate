package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Actor;
import ru.alishev.springcourse.model.Movie2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManyToManyExample {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Actor.class).addAnnotatedClass(Movie2.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {

            session.beginTransaction();

//            Movie2 movie = new Movie2("Pulp function", 1994);
//            Actor actor1 = new Actor("Harvey Keitel", 81);
//            Actor actor2 = new Actor("Samuel L. Jackson", 72);
//            movie.setActors(new ArrayList<>(List.of(actor2, actor1)));
//            actor1.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            actor2.setMovies(new ArrayList<>(Collections.singletonList(movie)));

//            session.save(movie);
//            session.save(actor1);
//            session.save(actor2);

//            Movie2 movie2 =session.get(Movie2.class, 1);
//            System.out.println(movie2 + " " + movie2.getActors());

//            Movie2 movie = new Movie2("Reservoir Dogs", 1992);
//            Actor actor = session.get(Actor.class, 1);
//            movie.setActors(new ArrayList<>(Collections.singletonList(actor)));
//            actor.getMovies().add(movie);
//            session.save(movie);
            Actor actor = session.get(Actor.class, 2);
            Movie2 movieToRemove = actor.getMovies().get(0);
            actor.getMovies().remove(movieToRemove);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
