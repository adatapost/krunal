<!doctye html>

<%
  pageContext.setAttribute("no", 10);
  request.setAttribute("no", 100);
  session.setAttribute("no", 1000);
  application.setAttribute("no", 10000);
  
  out.println("<br/>Page : " + pageContext.getAttribute("no"));
  out.println("<br/>Request : " + request.getAttribute("no"));
  out.println("<br/>Session : " + session.getAttribute("no"));
  out.println("<br/>Application : " + application.getAttribute("no"));
%>    

<a href="page1.jsp">Page1</a>
