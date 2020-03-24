/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.webtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.sql.Statement;
/**
 *
 * @author aelinadas
 */
public class DriverConnection {
   public ResultSet connectAndRead(String fileName) {
        Connection connection = null;
        ResultSet results = null;
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            Properties properties = new Properties();
            properties.put("fileExtension", ".csv");
            if (!fileName.equalsIgnoreCase("")) {
                connection = DriverManager.getConnection("jdbc:relique:csv:/Users/aelinadas/Desktop/csv_data", properties);
            }

            if (connection != null) {
                Statement statement = connection.createStatement();
                if (fileName.equalsIgnoreCase("SalesOrder")) {
                    results = statement.executeQuery("SELECT * FROM "+fileName);
                    System.out.println(results);
                    return results;
                }

            }

            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    } 
}
