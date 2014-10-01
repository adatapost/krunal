<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  session.setAttribute("no",10) ;
  session.setAttribute("name","Raj");  
  out.println(session.getId());
%>    
 
<hr/>
<a href="<%=response.encodeRedirectURL("add-session.jsp")%> ">Add Data</a>
<a href='<c:url value="show-session.jsp"/>'>Show Data</a>
<a href='<c:url value="delete-session.jsp"/>'>Delete Data</a>

<form method="post" action="<c:url value="delete-session.jsp"/>">
    <input type="submit"/>
</form>