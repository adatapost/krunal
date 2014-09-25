<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty param.name}">
    <jsp:useBean id="now" class="java.util.Date"/>
    <h3>Welcome ${param.name}</h3>
    <fmt:formatDate value="${now}" pattern="dd-MM-yyyy"/>
</c:if>

<c:if test="${empty param.name}">
    <form method="post">
        Enter your name : <input type="text" name="name" />
        <input type="submit"/>
    </form>
</c:if>