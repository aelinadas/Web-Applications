/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import neu.edu.models.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author aelinadas
 */
public class MovieDAO {
    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    private Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    private void beginTransaction() {
        getSession().beginTransaction();
    }

    private void commit() {
        getSession().getTransaction().commit();;
    }

    private void close() {
        getSession().close();
    }

    private void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }

    public int addMovies(String title, String actor, String actress, String genre, int year) {
        int result = 0;
        try {
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);
            beginTransaction();
            getSession().save(movie);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
    }
    
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Movie");
            movies = q.list();
            commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return movies;
    }
    
    
    public Movie getMoviesByID(int id){
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Movie where movieID= :id");
            q.setInteger("id", id);
            Movie movie = (Movie) q.uniqueResult();
            return movie;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return null;
    }
    
    public int updateMovie(int id, String title, String actor, String actress, String genre, int year){
        int result = 0;
        try{
            beginTransaction();
            Query q = getSession().createQuery("from Movie where movieID= :id");
            q.setInteger("id", id);
            Movie movie = (Movie) q.uniqueResult();
            movie.setActor(actor);
            movie.setActress(actress);
            movie.setGenre(genre);
            movie.setYear(year);
            getSession().save(movie);
            commit();
            result = 1;
        } catch(HibernateException ex){
            ex.printStackTrace();
            rollbackTransaction();
        } finally{
            close();
        }
        return result;
    }
    
    public int deleteMovieById(int id) {
        int result = 0;
        try {
            beginTransaction();
            Query q = getSession().createQuery("from Movie where movieID= :id");
            q.setInteger("id", id);
            Movie movieToDelete = (Movie) q.uniqueResult();
            getSession().delete(movieToDelete);
            commit();
            result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            rollbackTransaction();
        } finally {
            close();
        }
        return result;
    }
    
}
