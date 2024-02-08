package ru.alishev.springcourse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.alishev.springcourse.model.Director;
import ru.alishev.springcourse.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OtMPractice {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();


//            Director director = new Director("Birt");
            Director director = session.get(Director.class, 1);
          List<Movie> movies = director.getMovies();
            System.out.println(movies);

//            Movie movie = new Movie("District", director);
//            director.setMovies(new ArrayList<>(Collections.singletonList(movie)));
//            session.save(director);
//            session.save(movie);


            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
