<%-- 
    Document   : index
    Created on : Oct 6, 2014, 8:41:50 AM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <base href="/LoginApp/admin/"/>
    </head>
    <body>
        <h1>Welcome Admin ${isLogin}</h1>
        <hr/>
        <a href="index.jsp">Home</a>
        <a href="login">Logout</a>
        
    </body>
</html>
