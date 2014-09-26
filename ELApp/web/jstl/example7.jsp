<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:choose>
    <c:when test="${param.action eq 'google'}">
        <c:redirect url="http://www.google.com"/>
    </c:when>
    <c:when test="${param.action eq 'facebook'}">
        <c:redirect url="http://www.facebook.com"/>
    </c:when>
     <c:when test="${param.action eq 'home'}">
        <c:redirect url="example1.jsp"/>
    </c:when>
</c:choose>    

<a href="?action=google">Google</a>
<a href="?action=facebook">Facebook</a>
<a href="?action=home">Home</a>