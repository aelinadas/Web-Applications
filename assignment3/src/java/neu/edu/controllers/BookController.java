/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import neu.edu.models.BookDAO;

/**
 *
 * @author aelinadas
 */
public class BookController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("number")) {
                int num = Integer.parseInt(request.getParameter("books"));
                request.setAttribute("num", num);
                System.out.println(request.getParameter("books"));
                RequestDispatcher rd = request.getRequestDispatcher("/books/booksadd.jsp");
                rd.forward(request, response);

            }
            if (action.equalsIgnoreCase("add")) {
                System.out.println("Inside add");
                BookDAO bookdao = new BookDAO();
                int books = Integer.parseInt(request.getParameter("booksToBeAdded"));
                bookdao.addBooks(books, request);
                if (books != 0) {
                    request.setAttribute("numberOfBooks", books);
                    RequestDispatcher rd = request.getRequestDispatcher("/books/booksview.jsp");
                    rd.forward(request, response);
                }
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
