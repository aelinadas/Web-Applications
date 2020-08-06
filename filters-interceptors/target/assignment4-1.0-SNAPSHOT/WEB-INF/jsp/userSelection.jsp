<%-- 
    Document   : userSelection
    Created on : Feb 21, 2020, 8:26:31 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movie Store</title>
    </head>
    <body>
        <h1>Welcome to our Movie Store</h1>
        <p><b> Please select one option: </b></p><br>
        <form action="#" id="movieForm">
            <Label>Select Mapping*:</Label><br/><br/>
            <input type="radio" class="input-hidden" name="selUrl" value="simpleMovie.htm" required/>Simple URL Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="beanMovieController.htm"/>Bean Name URL Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="classmovie.htm"/>Controller Class Name Handler Mapping
            <input type="radio" class="input-hidden" name="selUrl" value="interceptor.htm"/>Interceptor
            <input type="radio" class="input-hidden" name="selUrl" value="filter.htm"/>Filter<br><br>
            <input type="submit" value="Add Movie" name="addMovie" >
            <input type="hidden" value="add" name="option" />
        </form>
        <br>
        <form action="#" id="retrieveForm">
            <Label>Select Mapping*:</Label><br/><br/>
            <input type="radio" class="input-r" name="selUrl" value="simpleMovie.htm" required/>Simple URL Handler Mapping
            <input type="radio" class="input-r" name="selUrl" value="beanMovieController.htm"/>Bean Name URL Handler Mapping
            <input type="radio" class="input-r" name="selUrl" value="classmovie.htm"/>Controller Class Name Handler Mapping
            <input type="radio" class="input-r" name="selUrl" value="interceptor.htm"/>Interceptor
            <input type="radio" class="input-r" name="selUrl" value="filter.htm"/>Filter<br><br>
            <input type="submit" value="Retrieve Movie" name="getMovie" >
            <input type="hidden" value="get" name="option" />
        </form> 
        <script>
        var radios = document.getElementsByClassName('input-hidden');
        for (var i = 0; i < radios.length; i++) {
            radios[i].addEventListener('change', function (e) {
                document.getElementById('movieForm').setAttribute('action', e.target.value);
            }, false);
        }
        var radios2 = document.getElementsByClassName('input-r');
        for (var i = 0; i < radios2.length; i++) {
            radios2[i].addEventListener('change', function (e) {
                document.getElementById('retrieveForm').setAttribute('action', e.target.value);
            }, false);
        }
    </script>
    </body>
</html>
