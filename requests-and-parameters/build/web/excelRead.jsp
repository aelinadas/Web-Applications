<%-- 
    Document   : excelRead
    Created on : Feb 9, 2020, 5:20:47 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.apache.poi.ss.usermodel.*" %>
<%@ page import="org.apache.poi.hssf.usermodel.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileNotFoundException" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Read Excel</title>
    </head>
    <body>
        <%
            String filePath = "/Users/aelinadas/Desktop/csv_data/";
            try {
                String fileName = request.getParameter("fileName");
                //System.out.println(filePath + fileName + ".xls");
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath + fileName + ".xls"));
                HSSFSheet datatypeSheet = workbook.getSheetAt(0);
                Iterator<Row> iterator = datatypeSheet.iterator();

                while (iterator.hasNext()) {
                    Row currentRow = iterator.next();
                    Iterator<Cell> cellIterator = currentRow.iterator();
                    while (cellIterator.hasNext()) {
                        Cell currentCell = cellIterator.next();
                        if (currentCell.getCellType() == CellType.STRING) {
                            System.out.print(currentCell.getStringCellValue() + " | ");
        %>
        <jsp:scriptlet> out.print(currentCell.getStringCellValue() + " | ");</jsp:scriptlet>
        <%
        } else if (currentCell.getCellType() == CellType.NUMERIC) {
            System.out.print(currentCell.getNumericCellValue() + " | ");
        %>
        <jsp:scriptlet> out.print(currentCell.getNumericCellValue() + " | ");</jsp:scriptlet>
        <%                }

            }
        %>
        <br>
        <%
                }
            } catch (FileNotFoundException e) {
                //out.print("<h1>No such file exist</h1>");
                out.print(e.getMessage());
            } catch (IOException e) {
                //out.print("<h1>No such file exist</h1>");
                out.print(e.getMessage());
            }
        %>

    </body>
</html>

