<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<select>
<c:forEach var="no" begin="1" end="10" step="2">
    <option>${no}</option>
</c:forEach>
</select>    

<select>
    <c:forEach var="item" items="Jan,Feb,Mar">
        <option>${item}</option>
    </c:forEach>
</select>

 <jsp:include page="../data">
      <jsp:param name="action" value="categories"/>
    </jsp:include>

    <c:forEach var="cat" items="${categories}">
       <br/>${cat[0]}  ${cat[1]}
    </c:forEach>
       
 <select>
    <c:forEach var="item" items="${categories}">
        <option value="${item[0]}">${item[1]}</option>
    </c:forEach>
</select>