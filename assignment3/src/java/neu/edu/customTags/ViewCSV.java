/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.customTags;

import neu.edu.controllers.DriverConnection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/**
 *
 * @author aelinadas
 */
public class ViewCSV extends SimpleTagSupport {

    private String file;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        try {
            if (!file.equalsIgnoreCase("")) {
                DriverConnection driverConnection = new DriverConnection();
                ResultSet results = driverConnection.connectAndRead(file);
                if (results != null) {
                    out.println("<h1>Result Records</h1>");
                    ResultSetMetaData rsmd = results.getMetaData();
                    int columnsNumber = results.getMetaData().getColumnCount();
                    while (results.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) {
                                out.print(" || ");
                            }
                            String columnValue = results.getString(i);
                            out.print(rsmd.getColumnName(i) + " : " + columnValue);
                        }
                        out.println("<br>");
                    }
                }
            } else {
                out.println("<h1>No such file exist in the directory</h1>");
            }

        } catch (Exception ex) {
            throw new JspException("Error in ViewCSV tag", ex);
        }
    }

    public void setFile(String file) {
        this.file = file;
    }

}
