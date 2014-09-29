<%-- 
    Document   : index
    Created on : Sep 27, 2014, 8:06:52 AM
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
        <h3>File Upload</h3>
         
        ${realPath}
        <br/>${path}
        <form method="post"
              action="upload"
            enctype="multipart/form-data">
             
            <p>No: <input type="text" name="empNo"/></p>
            <p>Name: <input type="text" name="empName"/></p>
            <input type="file" name="file"/>
            <input type="submit" name="cmd" value="Upload"/>
        </form>
        ${message}
        
        <c:forEach var="e" items="${emps}">
            <div>
                ${e[0]} ${e[1]}
                <img src="files/${e[2]}" style="width:40px;" />
            </div>
        </c:forEach>
    </body>
</html>
