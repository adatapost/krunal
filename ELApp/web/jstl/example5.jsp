<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="no" value="10"/>
<c:catch var="ex">
    <c:set var="no" value="${no * 3}"/>
</c:catch>

<c:choose>
    <c:when test="${empty ex}">
        Result : ${no}
    </c:when>
    <c:otherwise>
        ${ex}
    </c:otherwise>
</c:choose>