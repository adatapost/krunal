<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="no" scope="page" value="10"/>
<c:set var="info" scope="request" value="<h1>Hello World</h1>"/>
<c:set var="data" scope="request" value="<script>alert('Hello');</script>"/>

<br/>EL ${no} ${info} ${data}

<br/>JSTL 
<br/><c:out value="${no}"/>
<br/><c:out value="${info}"/>
<br/><c:out value="${data}"/>
<br/><c:out value="${info}" escapeXml="false"/>

<c:remove var="no"/>
<c:remove var="info" scope="request"/>

<br/>After Removing = <c:out value="${no}"/>