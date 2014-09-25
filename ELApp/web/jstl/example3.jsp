<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty param.no}">
    <c:choose>
        <c:when test="${param.no == 1}">
            <h4>Jan</h4>
        </c:when>
        <c:when test="${param.no eq 2}">
            <h4>Feb</h4>
        </c:when>
        <c:otherwise>
            <h4>Other month or invalid month number</h4>
        </c:otherwise>
    </c:choose>
</c:if>

<c:if test="${empty param.no}">
    <form method="post">
        Enter month no : <input type="text" name="no" />
        <input type="submit"/>
    </form>
</c:if>