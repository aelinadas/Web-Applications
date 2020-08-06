<%-- 
    Document   : addMovie
    Created on : Feb 21, 2020, 6:54:39 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h1>Movie Application</h1>
        <form action="#" method="post" id="movie">
            Title<input type="text" name="title" required /><br/><br/>
            Actor<input type="text" name="actor" /><br/><br/>
            Actress<input type="text" name="actress" /><br/><br/>
            Genre<input type="text" name="genre" /><br/><br/>
            Year<input type="text" name="year" /><br/><br/>
            <input type="hidden" value="submitmovie" name="option" />
            <Label>Select Mapping*:</Label><br/><br/>
            <input type="radio" class="input-hidden" name="selUrl" value="simpleMovie.htm" required/>Simple URL Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="beanMovieController.htm"/>Bean Name URL Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="classmovie.htm"/>Controller Class Name Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="interceptor.htm"/>Interceptor
            <input type="radio" class="input-hidden" name="selUrl" value="filter.htm"/>Filter<br><br>
            <input type="submit" name="submit" />
        </form>
        <br><a href="index.htm">Go back to Home page</a>
    </body>
    <script>
        var radios = document.getElementsByClassName('input-hidden');
        for (var i = 0; i < radios.length; i++) {
            radios[i].addEventListener('change', function (e) {
                document.getElementById('movie').setAttribute('action', e.target.value);
            }, false);
        }
    </script>
</html>

