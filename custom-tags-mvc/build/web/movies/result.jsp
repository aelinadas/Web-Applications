<%-- 
    Document   : result
    Created on : Feb 16, 2020, 5:29:52 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>Results</h1>
        <c:choose>
            <c:when test="${empty requestScope.movieList}">
                <h2>No Movie/Movies Found</h2>
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope.movieList}" var = "movie">
                    <label>Movie Title: </label><c:out value="${movie.title}"/><br>
                    <label>Lead Actor: </label><c:out value="${movie.actor}"/><br>
                    <label>Lead Actress: </label><c:out value="${movie.actress}"/><br>
                    <label>Genre: </label><c:out value="${movie.genre}"/><br>
                    <label>Year: </label><c:out value="${movie.year}"/><br>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <br>
        <a href="/assignment3/moviestore.html">Click here to go back to main page</a>
    </body>
</html>
