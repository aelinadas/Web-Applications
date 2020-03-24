<%-- 
    Document   : booksview
    Created on : Feb 16, 2020, 11:28:35 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books View</title>
    </head>
    <body>
        <h1>Number of books added are:</h1>
        <c:out value="${requestScope.numberOfBooks}"></c:out>
    </body>
</html>
