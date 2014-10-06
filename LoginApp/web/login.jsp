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
        <title>Login</title>
    </head>
    <body>
        <h1>Login System</h1>
        <hr/>
        <a href="index.jsp">Home</a>
        <a href="login.jsp">Login</a>
        
        <h3>
            Login
        </h3>
        <form method="post" action="login">
            <br/>Username : <input type="text" name="username"/>
            <br/>Password : <input type="password" name="password"/>
            <br/><input type="submit"/>
        </form>
    </body>
</html>
