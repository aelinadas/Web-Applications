/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.controllers;

import neu.edu.models.Movie;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import neu.edu.models.MovieDAO;

/**
 *
 * @author aelinadas
 */
public class MovieConnector extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String action = request.getParameter("action");

            if (action.equalsIgnoreCase("add")) {
                String title = request.getParameter("title");
                String actor = request.getParameter("actor");
                String actress = request.getParameter("actress");
                String genre = request.getParameter("genre");
                int year = Integer.parseInt(request.getParameter("year"));
                MovieDAO moviedao = new MovieDAO();
                moviedao.addMovies(title, actor, actress, genre, year);
                RequestDispatcher rd = request.getRequestDispatcher("/movies/add.jsp");
                rd.forward(request, response);
            }
            if (action.equalsIgnoreCase("browse")) {
                String keyword = request.getParameter("keyword");
                String filter = request.getParameter("choose");
                MovieDAO moviedao = new MovieDAO();
                ArrayList<Movie> movieList = moviedao.searchMovies(keyword, filter);
                request.setAttribute("movieList", movieList);
                request.setAttribute("searchword", keyword);
                RequestDispatcher rd = request.getRequestDispatcher("/movies/result.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
