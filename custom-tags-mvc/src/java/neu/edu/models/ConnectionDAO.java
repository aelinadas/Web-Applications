/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author aelinadas
 */
public class ConnectionDAO {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
    static final String USER = "root";
    static final String PASSWORD = "Aelina12#";

    public Connection getConnection() throws Exception {
        Connection connection = null;
        try {   
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
}
