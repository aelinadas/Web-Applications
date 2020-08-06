<%-- 
    Document   : booksadd
    Created on : Feb 17, 2020, 12:57:11 AM
    Author     : aelinadas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Books</title>
    </head>
    <body>
        <h1>Add Books</h1>
             
        <c:if test="${not empty requestScope.num}">
            <c:set var = "nums" value = "${requestScope.num}"/>
            <form action="books.htm?action=add" method="POST">
                <table border="2">
                    <thead>
                        <tr>
                            <th>ISBN</th>
                            <th>Book Title</th>
                            <th>Authors</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "i" begin = "1" end = "${nums}">
                            <tr>
                                <td><input type="text" name="isbn${i}" required></td>
                                <td><input type="text" name="title${i}" required></td>
                                <td><input type="text" name="authors${i}" required></td>
                                <td><input type="text" name="price${i}" required></td>
                            </tr>
                        </c:forEach>
                    </tbody> 
                </table>
                <input type="hidden" name="booksToBeAdded" value="${nums}">
                <input type="submit" value="Add Books">
            </form>   
        </c:if>
    </body>
</html>
