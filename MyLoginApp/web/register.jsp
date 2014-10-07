<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Login"/>
<%@include file="templates/header.jspf" %>

<h3>Login</h3>

<h4><a href="register">New user?</a></h4>

<form method="post" action="login">
    <p>Username</p>
    <p><input type="text" name="userName"/></p>
    <p>Password</p>
    <p><input type="password" name="userPass"/></p>   
    <p>Confirm Password</p>
    <p><input type="password" name="confirmPassword"/></p>  
    <p>Email</p>
    <p><input type="email" name="userEmail"/></p>    

    <p>Question</p>
    <p><input type="text" name="question"/></p>
    <p>Answer</p>
    <p><input type="text" name="answer"/></p>
    <p><input type="submit" name="cmd" value="Register"/></p>
    <p>
        ${message}
    </p>
</form>

<h4><a href="recover">Forgot password?</a></h4>

<%@include file="templates/footer.jspf" %>
