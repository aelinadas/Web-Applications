<%-- 
    Document   : form
    Created on : Feb 7, 2020, 2:11:11 PM
    Author     : aelinadas
--%>

<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
    </head>
    <body>
        <h2>Your Details</h2>
        <% String email = request.getParameter("email");
            if (email != null) {
                out.print("Email: ");
        %>
        <%= email %>
        <% } %>
        <br/>
        <% String password = request.getParameter("password");
            if (password != null) {
                out.println("Password: " + password);
            }
        %>
        <br/>
        <% String confirmpassword = request.getParameter("confirmpassword");
            if (confirmpassword != null) {
                out.println("Confirm Password: " + confirmpassword);
            }
        %>
        <br/>
        <% String image = request.getParameter("image");
            if (image != null) {
                out.println("File: " + image);
            }
        %>
        <br/>
        <% String gender = request.getParameter("gender");
            if (gender != null) {
                out.println("Gender: " + gender);
            }
        %>
        <br/>
        <% String country = request.getParameter("country");
            if (country != null) {
                out.println("Country: " + country);
            }
        %>
        <br/>
        <% String[] hobby = request.getParameterValues("hobby");
            if (hobby != null) {
                out.println("Hobby: " + Arrays.toString(hobby).substring(1, Arrays.toString(hobby).length()-1));
            }
        %>
        <br/>
        <% String address = request.getParameter("address");
            if (address != null) {
                out.println("Address " + address);
            }
        %>
        <br/>
        <a href="exit.jsp" >Click to Logout </a>
    </body>
</html>
