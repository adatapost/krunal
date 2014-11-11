<%-- 
    Document   : product
    Created on : Nov 11, 2014, 8:12:57 AM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="emp">
            <p>Emp No</p>
            <p><input type="text" name="empNo" value="${emp.empNo}"/></p>
            <p>Emp Name</p>
            <p><input type="text" name="empName" value="${emp.empName}"/></p>
            <p>Department</p>
            <p>
                <select name="deptNo">
                    <c:forEach var="d" items="${depts}">
                        <c:if test="${d.deptNo ne emp.dept.deptNo}">
                            <option value="${d.deptNo}">${d.deptName}</option>
                        </c:if>
                        <c:if test="${d.deptNo eq emp.dept.deptNo}">
                            <option selected value="${d.deptNo}">${d.deptName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </p>
            <p>
                <c:if test="${empty emp}">
                    <input type="submit" name="cmd" value="Add"/>
                </c:if>
                <c:if test="${not empty emp}">
                    <input type="submit" name="cmd" value="Update"/>
                    <input type="submit" name="cmd" value="Delete"/>
                    <input type="submit" name="cmd" value="Cancel"/>
                </c:if>
            </p>

        </form>
        <h3>List of Employees</h3>
        <table border="1">
            <c:forEach var="e" items="${emps}">
                <tr>
                    <td>${e.empNo}</td>
                    <td>${e.empName}</td>
                    <td>${e.dept.deptName}</td>
                    <td>
                        <form method="post" action="emp">
                            <input type="hidden" name="empNo" value="${e.empNo}"/>
                            <input type="submit" name="cmd" value="Edit"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
