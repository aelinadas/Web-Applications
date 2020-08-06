<%-- 
    Document   : login
    Created on : Feb 18, 2020, 2:24:53 PM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html>
  <head><title></title>
  </head>
  <body>
        <h2>Login</h2>
        <form name="loginForm" method="POST" action="LoginServlet">
            <p>User name: <input type="text" name="username" size="20"/></p><br>
            <p>Password: <input type="password" size="20" name="password"/></p><br>
            <p>  <input type="submit" value="Submit"/></p>
        </form>       
   </body>
</html>
