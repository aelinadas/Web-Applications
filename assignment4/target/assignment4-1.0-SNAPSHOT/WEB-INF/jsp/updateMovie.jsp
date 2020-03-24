<%-- 
    Document   : updateMovie
    Created on : Feb 29, 2020, 12:30:37 AM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update</title>
    </head>
    <body>
        <h1>Update Movies</h1>
        <hr>
        <form action="#" method="post" id="movieForm">
            Movie ID<input type="text" name="movieID" value="${movies.getMovieID()}" readonly/><br/><br/>
            Title<input type="text" name="title" value="${movies.getTitle()}" readonly/><br/><br/>
            Actor<input type="text" name="actor" value="${movies.getActor()}"/><br/><br/>
            Actress<input type="text" name="actress" value="${movies.getActress()}"/><br/><br/>
            Genre<input type="text" name="genre" value="${movies.getGenre()}"/><br/><br/>
            Year<input type="text" name="year" value="${movies.getYear()}"/><br/><br/>
            <input type="hidden" value="updateMovie" name="option" />
            <Label>Select Mapping*:</Label><br/><br/>
            <input type="radio" class="input-hidden" name="selUrl" value="simpleMovie.htm" required/>Simple URL Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="beanMovieController.htm"/>Bean Name URL Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="classmovie.htm"/>Controller Class Name Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="interceptor.htm"/>Interceptor
            <input type="radio" class="input-hidden" name="selUrl" value="filter.htm"/>Filter<br><br>
            <input type="submit" name="submit" />
        </form>
        <script>
            var radios = document.getElementsByClassName('input-hidden');
            for (var i = 0; i < radios.length; i++) {
                radios[i].addEventListener('change', function (e) {
                    document.getElementById('movieForm').setAttribute('action', e.target.value);
                }, false);
            }
        </script>
    </body>
</html>
