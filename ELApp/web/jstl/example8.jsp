<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:choose>
    <c:when test="${param.action eq 'google'}">
        <c:import url="http://www.google.com" var="data"/>
    </c:when>
    <c:when test="${param.action eq 'facebook'}">
        <c:import url="http://www.facebook.com" var="data"/>
    </c:when>
     <c:when test="${param.action eq 'home'}">
         <c:import url="example1.jsp" var="data"/>
    </c:when>
</c:choose>    

<a href="?action=google">Google</a>
<a href="?action=facebook">Facebook</a>
<a href="?action=home">Home</a>
<hr/>
${data}

