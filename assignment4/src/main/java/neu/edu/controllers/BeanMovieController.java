/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import neu.edu.dao.MovieDAO;
import neu.edu.models.Movie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author aelinadas
 */
public class BeanMovieController extends AbstractController {
    
    public BeanMovieController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //throw new UnsupportedOperationException("Not yet implemented");
        ModelAndView mv = null;
        
        String option = request.getParameter("option") == null ? "" : request.getParameter("option");
        MovieDAO movieDao = new MovieDAO();

        if (option == null || option == "") {
            mv = new ModelAndView("userSelection");
            return mv;
        } else if (option.equalsIgnoreCase("add")) {
            mv = new ModelAndView("addMovie");
        } else if (option.equalsIgnoreCase("get")) {
            List<Movie> list = movieDao.getMovies();
            mv = new ModelAndView("getAllMovies","movies",list);
        }else if(option.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt((request.getParameter("id")));
            int result = movieDao.deleteMovieById(id);
            if(result == 1 ){
                String msg = "Movie with id "+id+" has been deleted successfully";
                mv = new ModelAndView("success","message", msg);
            } else{
                String msg = "Movie cannot be deleted at this point of time";
                mv = new ModelAndView("error", "message", msg);
            }
        }else if (option.equalsIgnoreCase("update")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Movie movie = movieDao.getMoviesByID(id);
            mv = new ModelAndView("updateMovie", "movies", movie);
            return mv;  
        }else if (option.equalsIgnoreCase("updateMovie")) {
            System.out.println("Inside Update");
            int id = Integer.parseInt(request.getParameter("movieID"));
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            int result = movieDao.updateMovie(id, title, actor, actress, genre, year);
            if (result == 1) {
                String msg = "Movie with id " + id + " has been updated successfully";
                mv = new ModelAndView("success", "message", msg);
            } else {
                String msg = "Movie cannot be updated at this point of time";
                mv = new ModelAndView("error", "message", msg);
            }
        }else {
            String title = request.getParameter("title");
            String actor = request.getParameter("actor");
            String actress = request.getParameter("actress");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            int result = movieDao.addMovies(title, actor, actress, genre, year);
            if (result == 1) {
                String mov ="1 Movie has been added successfully";
                mv = new ModelAndView("success","message", mov);
            } else {
                mv = new ModelAndView("error", "message", "Not able to add movie");
            }
        }
        return mv;
    }
}

