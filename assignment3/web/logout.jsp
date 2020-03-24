<%-- 
    Document   : logout
    Created on : Feb 18, 2020, 2:25:24 PM
    Author     : aelinadas
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    request.logout();
    session.invalidate();
    response.sendRedirect("thankyou.jsp");
%>
