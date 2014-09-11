<!doctye html>

<%
  out.println("<br/>Page : " + pageContext.getAttribute("no"));
  out.println("<br/>Request : " + request.getAttribute("no"));
  out.println("<br/>Session : " + session.getAttribute("no"));
  out.println("<br/>Application : " + application.getAttribute("no"));
%>    

<a href="index.jsp">Back</a>
