<%-- 
    Document   : index
    Created on : Oct 10, 2014, 8:50:37 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Students</h1>
        <jsp:include page="student-data"></jsp:include>
        
        <c:forEach var="s" items="${students}">
            <p>${s.roll}  ${s.name}  ${s.className}</p>
        </c:forEach>
    </body>
</html>
