<%-- 
    Document   : view
    Created on : Feb 9, 2020, 3:47:31 AM
    Author     : aelinadas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Cart</title>
    </head>
    <body>
        <h2>My Cart</h2>
        <c:if test="${not empty sessionScope.myCart}">
            <form action="../order.htm?action=delete" method="POST">
                <table border="1">
                    <c:forEach items="${sessionScope.myCart}" var="products">
                        <tr>
                            <td><c:out value="${products}"/><br/></td>
                            <td><input type="checkbox" name="product" value="${products}"/>Remove Item</td>
                        </tr>
                    </c:forEach>
                </table>
                <br/>
                <input type="submit" value="Remove Products" />
                <br/>
            </form>
        </c:if>
    </body>
</html>
