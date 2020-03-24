/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author aelinadas
 */
public class BookDAO {

    public int addBooks(int numberOfBooks, HttpServletRequest request) {
        int result = 0;
        try {
            ConnectionBooksDAO connection = new ConnectionBooksDAO();
            Connection con = connection.getConnection();
            String insert = "INSERT INTO bookdb.book(isbn,title,authors,price)values(?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(insert);
            for (int i = 1; i <= numberOfBooks; i++) {
                preparedStatement.setString(1, request.getParameter("isbn" + i));
                preparedStatement.setString(2, request.getParameter("title" + i));
                preparedStatement.setString(3, request.getParameter("authors" + i));
                preparedStatement.setString(4, request.getParameter("price" + i));
                result = preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
