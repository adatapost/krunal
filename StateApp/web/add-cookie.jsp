<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
   Cookie c1=new Cookie("no", "10");
   c1.setPath("/");
   c1.setMaxAge( 60 * 2 );
   //instructs the web-browser to create cookie
   response.addCookie(c1);
%>    
 
<hr/>
<a href="add-cookie.jsp">Add Data</a>
<a href='show-cookie.jsp'>Show Data</a>
<a href='delete-cookie.jsp'>Delete Data</a>

 