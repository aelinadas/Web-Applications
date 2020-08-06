<%-- 
    Document   : readcsv
    Created on : Feb 18, 2020, 2:26:19 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="records.xls" method="POST">
            <label>Please enter file name:
                <input type="text" name="file">
            </label>
            <br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
