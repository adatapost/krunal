<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:forTokens items="10|20|30,40|50" delims=",|" var="no">
    <br/>${no}
</c:forTokens>

    <c:set var="emails" value="a@a.com;b@b.com;c@c.com"/>
<c:forTokens items="${emails}" delims=";" var="email">
    <br/>${email}
</c:forTokens>    