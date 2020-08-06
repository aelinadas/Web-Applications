<%-- 
    Document   : displayexcel
    Created on : Feb 18, 2020, 2:23:50 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.apache.poi.ss.usermodel.*" %>
<%@ page import="org.apache.poi.hssf.usermodel.*" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <%
            if (request.getAttribute("data") != null) {
                Iterator<Sheet> sheetIterator = (Iterator<Sheet>) request.getAttribute("data");
                while (sheetIterator.hasNext()) {
                    Sheet sheet = sheetIterator.next();
                    Iterator<Row> iterator = sheet.iterator();
                    while (iterator.hasNext()) {
                        Row currentRow = iterator.next();
                        Iterator<Cell> cellIterator = currentRow.iterator();
                        while (cellIterator.hasNext()) {
                            Cell currentCell = cellIterator.next();
                            if (currentCell.getCellType() == CellType.STRING) {
        %>
        <jsp:scriptlet> out.print(currentCell.getStringCellValue() + " | ");</jsp:scriptlet>
        <%
        } else if (currentCell.getCellType() == CellType.NUMERIC) {
        %>
        <jsp:scriptlet> out.print(currentCell.getNumericCellValue() + " | ");</jsp:scriptlet>
        <%                }

            }
        %>
        <br>
        <%
                }
            }
        %>
        <a href="logout.jsp">Logout</a>
        <%
        } else {

        %>
        <h1>No Results Found<h1>
                <%                    }
                %>
                </body>
                </html>
