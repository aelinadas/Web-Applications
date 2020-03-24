/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
/**
 *
 * @author aelinadas
 */
public class DisplayExcelServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.authenticate(response)) {
            try {
                String filePath = "/Users/aelinadas/Desktop/csv_data/";
                String file = request.getParameter("file");
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath + file + ".xls"));
                Iterator<Sheet> sheetIterator = workbook.iterator();
                if (sheetIterator != null) {
                    request.setAttribute("data", sheetIterator);
                }
                RequestDispatcher rd = request.getRequestDispatcher("/displayexcel.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                request.setAttribute("data", null);
                RequestDispatcher rd = request.getRequestDispatcher("/displayexcel.jsp");
                rd.forward(request, response);
            }
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
