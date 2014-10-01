<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  session.removeAttribute("no") ;
  session.removeAttribute("name");  
  
%>
 <% out.println(session.getId()); %>
<hr/>
<a href="<%=response.encodeRedirectURL("add-session.jsp")%> ">Add Data</a>
<a href='<c:url value="show-session.jsp"/>'>Show Data</a>
<a href='<c:url value="delete-session.jsp"/>'>Delete Data</a>