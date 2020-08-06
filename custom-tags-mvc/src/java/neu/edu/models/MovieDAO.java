/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author aelinadas
 */
public class MovieDAO {

    public void addMovies(String title, String actor, String actress, String genre, int year) {
        try {
            ConnectionDAO connection = new ConnectionDAO();
            Connection conn = connection.getConnection();
            String insert = "insert into movies " + "(title,actor,actress,genre,year)" + "values ('" + title + "'," + "'" + actor + "', " + "'" + actress + "', " + "'" + genre + "', " + "'" + year + "')";
            Statement statement = conn.createStatement();
            statement.execute(insert);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Movie> searchMovies(String keyword, String filter) {
        try {
            ConnectionDAO connection = new ConnectionDAO();
            Connection conn = connection.getConnection();
            String search = "SELECT * FROM moviedb.movies WHERE " + filter + " = '" + keyword + "'";
            Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery(search);
            if (results != null) {
                ArrayList<Movie> movieList = new ArrayList<Movie>();
                while (results.next()) {
                    Movie movie = new Movie();
                    movie.setTitle(results.getString("title"));
                    movie.setActor(results.getString("actor"));
                    movie.setActress(results.getString("actress"));
                    movie.setGenre(results.getString("genre"));
                    movie.setYear(results.getInt("year"));
                    movieList.add(movie);
                }
                return movieList;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
