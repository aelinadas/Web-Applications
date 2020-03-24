<%-- 
    Document   : getAllMovies
    Created on : Feb 29, 2020, 10:27:22 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>
        <h1>Movies</h1>
        <table>
            <tr>
                <th>Title</th>
                <th>Actor</th>
                <th>Actress</th>
                <th>Genre</th>
                <th>Year</th>
            </tr>
            <c:forEach var="movies" items="${movies}">
                <tr>
                    <td><c:out value="${movies.getTitle()}" /></td>
                    <td><c:out value="${movies.getActor()}" /></td>
                    <td><c:out value="${movies.getActress()}" /></td>
                    <td><c:out value="${movies.getGenre()}" /></td>
                    <td><c:out value="${movies.getYear()}" /></td>
                    <td>
                        <a href="simpleMovie.htm?option=delete&id=${movies.getMovieID()}" id ="delete">
                            Delete 
                        </a> &nbsp;
                        <a href="simpleMovie.htm?option=update&id=${movies.getMovieID()}" id = "update">
                            Update 
                        </a>
                    </td>
                </tr>
            </c:forEach> 
        </table>
        <Label>Select Mapping*:</Label><br/><br/>
        <input type="radio" class="input-hidden" name="selUrl" value="simpleMovie.htm" required/>Simple URL Handler Mapping
        <input type="radio" class="input-hidden" name="selUrl" value="beanMovieController.htm"/>Bean Name URL Handler Mapping
        <input type="radio" class="input-hidden" name="selUrl" value="classmovie.htm"/>Controller Class Name Handler Mapping
        <input type="radio" class="input-hidden" name="selUrl" value="interceptor.htm"/>Interceptor
        <input type="radio" class="input-hidden" name="selUrl" value="filter.htm"/>Filter<br><br>

        <br><a href="index.htm">Go back to Home page</a>
    </body>
    <script>
        var radios = document.getElementsByClassName('input-hidden');
        for (var i = 0; i < radios.length; i++) {
            radios[i].addEventListener('change', function (e) {
                var tds = document.querySelectorAll("a#delete")
                for (var i = 0; i < tds.length; i++) {
                    var url = tds[i].getAttribute("href");
                    var urlArray = url.split("?");
                    var newURL = e.target.value + "?" + urlArray[1];
                    tds[i].setAttribute("href", newURL);
                }
                //Update 
                var updateChange = document.querySelectorAll("a#update")
                for (var i = 0; i < updateChange.length; i++) {
                    var url = updateChange[i].getAttribute("href");
                    var urlArray = url.split("?");
                    var newURL = e.target.value + "?" + urlArray[1];
                    updateChange[i].setAttribute("href", newURL);
                }
            }, false);
        }
    </script>
</html>
