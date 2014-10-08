<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Login"/>
<%@include file="templates/header.jspf" %>

<h3>Login</h3>

<h4><a href="register.jsp">New user?</a></h4>

<form method="post" action="login">
    <p>Username</p>
    <p><input type="text" name="userName"/></p>
    <p>Password</p>
    <p><input type="password" name="userPass"/></p>   
    <p>Remember Me? <input type="checkbox" name="rememberMe"/></p>
    
    <p><input type="submit" name="cmd" value="Login"/></p>
    <p>${message}</p>
</form>

<h4><a href="recover.jsp">Forgot password?</a></h4>

<%@include file="templates/footer.jspf" %>
