<%-- 
   Document   : page1
   Created on : Feb 7, 2020, 1:06:32 AM
   Author     : aelinadas
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>  
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix = "x" uri = "http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Page1</title>
   </head>
   <body>
      <h1>JSTL tags</h1>
      <h2>Core tags usage</h2>
      <c:set var="income" scope="session" value="${4000*4}"/>
      <c:if test="${income > 8000}">
         <p>
            My income is: 
            <c:out value="${income}"/>
         <p>
      </c:if>
      <c:choose>  
      <c:when test="${income <= 1000}">  
      Income is not good.  
      </c:when>  
      <c:when test="${income > 10000}">  
      Income is very good.  
      </c:when>  
      <c:otherwise>  
      Income is undetermined...  
      </c:otherwise>  
      </c:choose>  
      <c:forEach var="j" begin="1" end="3">  
      Item <c:out value="${j}"/><p>  
      </c:forEach>
      <h2>Function Tags Usage</h2>
      <c:set var="String" value="Welcome to function tags"/>
      <c:if test="${fn:contains(String, 'Functions')}">
         <p>Found
         <p>
      </c:if>
      <c:set var="str" value="This is Java EE"/>  
      <p>Length: ${fn:length(str)}</p>
      <c:set var="str1" value="WEB TOOLS"/>
      <c:set var="str2" value="hello world"/>
      <p>${fn:toLowerCase(str1)}</p>
      <p>${fn:toUpperCase(str2)}</p>
      <h2>Formatting Tags Usage</h2>
      <c:set var="str" value="<%=new java.util.Date()%>" />
      <fmt:timeZone value="${zone}">
         <fmt:formatDate value="${str}" timeZone="${zn}"  
            type="both"/>
      </fmt:timeZone>
      <c:set var="date" value="12-08-2016" />
      <fmt:parseDate value="${date}" var="parsedDate"  pattern="dd-MM-yyyy" />
      <p>
         <c:out value="${parsedDate}" />
      </p>
      <fmt:formatDate type="date" value="${Date}" />
      <h2>XML Tags:</h2>
      <c:set var = "xmltext">
         <books>
            <book>
               <name>Padam History</name>
               <author>ZARA</author>
               <price>100</price>
            </book>
            <book>
               <name>Great Mistry</name>
               <author>NUHA</author>
               <price>2000</price>
            </book>
         </books>
      </c:set>
      <x:parse xml = "${xmltext}" var = "output"/>
      <p>The title of the first book is: </p><x:out select = "$output/books/book[1]/name" />
      <br>
      <p>The price of the second book: </p><x:out select = "$output/books/book[2]/price" />
      <br>
      <x:choose>  
        <x:when select="$output//books/book[2]/price = '2000'">  
            <p>The book name is: </p><x:out select = "$output/books/book[2]/name" />  
        </x:when>  
        <x:when select="$output//books/book[1]/price = '100'"> 
            <p>The book name is: </p><x:out select = "$output/books/book[1]/name" />  
        </x:when>  
        <x:otherwise>  
           <p>The book name is: </p>
        </x:otherwise>  
       </x:choose> 
       <h2>SQL Tags:</h2>
       <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
         url="jdbc:mysql://localhost/test"  
         user="root"  password="Aelina12#"/>  
       <sql:query dataSource="${db}" var="rs">  
        SELECT * from Students;  
        </sql:query>  

        <table border="2" width="100%">  
        <tr>  
        <th>Student ID</th>  
        <th>First Name</th>  
        <th>Last Name</th>  
        <th>Age</th>  
        </tr>  
        <c:forEach var="table" items="${rs.rows}">  
        <tr>  
        <td><c:out value="${table.ID}"/></td>  
        <td><c:out value="${table.First_Name}"/></td>  
        <td><c:out value="${table.Last_Name}"/></td>  
        <td><c:out value="${table.Age}"/></td>  
        </tr>  
        </c:forEach>  
        </table>  
   </body>
</html>