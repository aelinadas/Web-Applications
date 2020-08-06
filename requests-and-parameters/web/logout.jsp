<%-- 
    Document   : logout
    Created on : Feb 7, 2020, 1:28:26 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
        <%
        session.invalidate();
        response.sendRedirect("index.jsp");
        %> 
    </body>
</html>
