<%-- 
    Document   : dept
    Created on : Nov 11, 2014, 7:54:30 AM
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
        <form method="post" action="dept">
            <p>Dept No</p>
            <p><input type="text" name="deptNo" value="${dept.deptNo}"/></p>
            <p>Dept Name</p>
            <p><input type="text" name="deptName" value="${dept.deptName}"/></p>   
            <p>
            <c:if test="${empty dept}">
                <input type="submit" name="cmd" value="Add"/>
            </c:if>
            <c:if test="${not empty dept}">
                <input type="submit" name="cmd" value="Update"/>
                <input type="submit" name="cmd" value="Delete"/>
            </c:if>                
            </p>
            <p>${message}</p>
        </form>
        <h3>List of Dept</h3>
        <table border="1">
            <c:forEach var="dept" items="${depts}">
                <tr>
                    <td>${dept.deptNo}</td>
                    <td>${dept.deptName}</td>
                    <td>
                        <form method="post" action="dept">
                            <input type="hidden" name="deptNo" value="${dept.deptNo}"/>
                            <input type="submit" name="cmd" value="Edit"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
