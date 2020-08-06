/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aelinadas
 */
public class ProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Inside");
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("cart")) {
            String[] cart = request.getParameterValues("product");
            HttpSession session = request.getSession(true);
            ArrayList myCart = (ArrayList)session.getAttribute("myCart");
            if(myCart == null){
                myCart = new ArrayList();
                session.setAttribute("myCart", myCart);
            }
            for(String c: cart){
                myCart.add(c);
            }
            System.out.println(Arrays.asList(myCart));
            RequestDispatcher rd = request.getRequestDispatcher("/store.html");
            rd.forward(request, response);
        }
         if(action.equalsIgnoreCase("delete")){
            System.out.println("I'm inside Delete");
            String[] cart = request.getParameterValues("product");
            HttpSession session = request.getSession(false);
            ArrayList myCart = (ArrayList)session.getAttribute("myCart");
            if(myCart != null){
                for(String c: cart){
                myCart.remove(c);
                }
            } 
            System.out.println(Arrays.asList(myCart));
            RequestDispatcher rd = request.getRequestDispatcher("/store.html");
            rd.forward(request, response);
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
